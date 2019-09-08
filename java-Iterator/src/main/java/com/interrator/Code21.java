package com.interrator;

import java.util.Scanner;

public class Code21 {
    public static void main(String[] ags){
        System.out.println(Integer.toBinaryString(5));
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for(int i = 0;i<k;i++){
            int[][] arr = new int[sc.nextInt()][3];
            for(int j = 0;j <arr.length;j++ ){
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
                arr[i][2]=sc.nextInt();
            }
            System.out.println(isArr(arr));
        }
    }
    public static boolean isArr(int[][] arr){
        boolean[] dp = new boolean[arr.length];
        for (int i = 0;i<dp.length;i++){
            if(!dp[i]){
                if(getLeft(arr,i,dp)==-1){
                    return false;
                }
            }
        }
        return true;
    }

    private static int getLeft(int[][] arr,int i,boolean[] dp) {
        if(i==-1){
            return 0;
        }
        if(dp[i]){
            return arr[i][0];
        }
        int left = getLeft(arr,arr[i][1],dp);
        int right = getLeft(arr,arr[i][2],dp);
        dp[i] = true;
        if (arr[i][1]==-1&&arr[i][2]==-1){
            return arr[i][0];
        }
        if(Math.min(left,right)==-1){
            return -1;
        }
        if(arr[i][1]==-1){
            if(arr[i][0]>=right){
                return -1;
            }
        }
        if(arr[i][2]==-1){
            if(arr[i][0]>=left){
                return -1;
            }
        }
        if(arr[i][0]>=Math.min(left,right)){
            return -1;
        }
        arr[i][0]=left+right+arr[i][0];
        return arr[i][0];
    }
}
