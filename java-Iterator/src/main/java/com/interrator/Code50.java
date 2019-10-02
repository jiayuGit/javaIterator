package com.interrator;

import java.util.Scanner;

public class Code50 {
    /**
     * 在数组环里连续相加最大值
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n*2];
        for(int i = 0;i<n;i++){
            arr[i]=in.nextInt();
            arr[i+n]=arr[i];
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n-1;i++){
            max= Math.max(max,getMax(arr,i,i+n));
        }
        System.out.println(max);
    }

    private static int getMax(int[] arr, int i, int j) {
        int res = 0;
        int max = Integer.MIN_VALUE;
        for(int k = i;k<j;k++){
            if(res+arr[k]>arr[k]){
                res +=arr[k];
            }else {
                res = arr[k]>0?arr[k]:0;
            }
            max = Math.max(res,max);
        }
        return max;
    }
}
