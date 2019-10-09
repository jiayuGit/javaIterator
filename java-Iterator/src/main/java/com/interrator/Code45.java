package com.interrator;

import java.util.Scanner;

public class Code45 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int [][] arr = new int[len][4];
        for(int i = 0;i<len;i++){
            for (int j = 0;j<arr[i].length;j++){
                arr[i][j]=in.nextInt();
            }
        }
        for (int i = 0;i<len;i++){
            int s =getMin(arr[i][0],arr[i][1],arr[i][2],arr[i][3],0);
            System.out.println(s);
        }
        System.out.println(gcd(102, 41));
        System.out.println(getZeroNum(1000000000));
        int a = 24;
        //获取二进制数最低不为0的位置
        a = ((a ^ (a - 1)) + 1) >> 1;
        System.out.println(a);
        System.out.println(getArrAnd("123456", "1123446"));
    }

    private static int getMin(int A, int B, int p, int q,int sum) {

        if(B<=A+p){
            return sum+1;
        }
        int min = getMin(A+p,B,p,q,sum+1);
        min = Math.min(min,getMin(A,B,p*q,q,sum+1));
        return min;
    }




    /**
     * 字符的公共连续子序列
     * @param s1
     * @param s2
     * @return
     */
    public static int getArrAnd(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        int[][] dp = new int[cs2.length][cs1.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < cs1.length; i++) {
            if (cs1[i] == cs2[0]) {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < cs2.length; i++) {
            if (cs1[0] == cs2[i]) {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < cs2.length; i++) {
            for (int j = 1; j < cs1.length; j++) {
                if (cs1[j] == cs2[i]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    /**
     * 1-N中有多少个0
     * @param n
     * @return
     */
    public static int getZeroNum(int n) {
        int res = 0;
        while (n != 0) {
            n /= 5;
            res += n;
        }
        return res;
    }

    public static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }

}
