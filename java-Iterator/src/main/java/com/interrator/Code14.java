package com.interrator;

public class Code14 {
    public static void main(String[] ags) {
        System.out.println(getString(new char[]{'A','B','C','D'},32 ));
        System.out.println(getInt(new char[]{'A','B','C','D'},"ACD"));
    }
    public static int getInt(char[] cs ,String s){
        char[] res = s.toCharArray();
        int dp = 0;
        int k = 1;
        for(int i = res.length-1;i>=0;i--){
            dp +=(getIndex(cs,res[i])*k);
            k*=cs.length;
        }
        return dp;
    }

    private static int getIndex(char[] cs, char re) {
        for (int i = 0;i<cs.length;i++){
            if(cs[i]==re){
                return i+1;
            }
        }
        return -1;
    }

    public static String getString(char[] cs, int n) {
        int k = cs.length;
        int count = 0;
        int sum = 1;
        while (n >=sum) {
            n -= sum;
            sum *= k;
            count++;
        }
        int[] dp = new int[count];
        int left = 0;
        while (left<dp.length) {
            sum /= k;
            dp[left++] = 1 + n / sum;
            n = n%sum;
        }
        System.out.println(dp);
        return null;
    }
}
