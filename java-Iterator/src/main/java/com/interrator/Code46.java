package com.interrator;

import java.util.Scanner;

public class Code46 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[][] arr = new int[len][];
        for (int i = 0; i<len;i++){
            arr[i]=new int[in.nextInt()];
            for(int j = 0;j<arr[i].length;j++){
                arr[i][j]=in.nextInt();
            }
        }
        for(int i = 0; i<len;i++){
            int k = getMax(arr[i]);
            System.out.println(k);
        }
    }

    private static int getMax(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for(int i = 0;i<arr.length;i++){
            dp[i][i]=arr[i];
        }
        int max = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                dp[i][j]=dp[i][j-1]+arr[j];
            }
        }
        for(int i = arr.length-1;i>0;i--){
            int sum = 1;
            for(int j = i-1;j>=0;j--){
                if(dp[j][i-1]<=arr[i]&&arr[j]<arr[j+1]){
                    sum++;
                }else {
                    break;
                }
                max=Math.max(max,sum);
            }
        }
        return max;
    }
}
