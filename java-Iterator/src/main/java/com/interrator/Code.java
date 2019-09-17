package com.interrator;

import java.util.Scanner;

public class Code {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k1 = sc.nextInt();
        int k2 = sc.nextInt();
        long[] arr = new long[k1];
        int[][] dp = new int[k1][2];
        for (int i = 0; i<k2;i++){
            dp[i][0]=sc.nextInt();
            dp[i][1]=sc.nextInt();
        }
        for(int i = 0; i<k2;i++){
            int left = dp[i][0];
            int right = dp[i][1];
            setArr(arr,i+1,left,right);
        }
        long sum = 0;
        for (int i = 0;i<arr.length;i++){
            sum +=(i*arr[i]);
        }
        sum = sum%100000009;
        System.out.println(sum);
    }

    private static void setArr(long[] arr, int i, int left, int right) {
        while (left<=right){
            arr[left]=i;
            arr[right]=i;
            left++;
            right--;
        }
    }
}
