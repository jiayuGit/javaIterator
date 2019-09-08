package com.interrator;

import java.util.Scanner;

public class Code22 {
    public static void main(String[] ags ){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for(int i = 0;i<k;i++){
            int m = sc.nextInt();
            boolean[] dp = new boolean[30];
            boolean[] res = new boolean[30];
            int[] arr = new int[sc.nextInt()];
            for(int j = 0;j<arr.length;j++){
                arr[j]=sc.nextInt();
            }
            int sum = 0;
            for(int j = 0;j<arr.length;j++){
                dp[arr[j]]=true;
                setDp(arr[j],dp,k);
                sum++;
            }
            for(int j = 0;j<dp.length;j++){
                if(!dp[j]){
                    dp[j]=true;
                    setDp(j,dp,k);
                    res[j]=true;
                    sum++;
                }
            }

            System.out.println(sum);
        }

    }

    private static void setDp(int i, boolean[] dp, int k) {
        for(int j=i-1,m=k;j>=0&&!dp[j]&&m>0;j--){
            dp[j] = true;
            m--;
        }
        for(int j=i+1,m=k;j<dp.length&&!dp[j]&&m>0;j++){
            dp[j] = true;
            m--;
        }
    }
}
