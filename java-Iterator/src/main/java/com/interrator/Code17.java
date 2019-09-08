package com.interrator;


/**
 * 最长回文子串
 */
public class Code17 {
    public static void main(String[] ags) {

        System.out.println(getMax("1232343231ab"));
    }

    public static int getMax(String ss) {
        char[] cs = getStrin(ss);
        int[] dp = new int[cs.length];
        int rp = -1;
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < cs.length; i++) {
            if (i > rp - 1) {
                int m = getNum(cs, i, 0);
                rp = m + i;
                index = i;
                dp[i]=m;
            }else if(i<=rp-1&&dp[i-(i-index)*2]-1+i<rp-1){
                dp[i] = dp[i-(i-index)*2];
            }else if(i<=rp-1&&dp[i-(i-index)*2]-1+i>=rp){
                dp[i] = rp-i;
            }else if(i<=rp-1&&dp[i-(i-index)*2]-1+i==rp-1){
                dp[i]=getNum(cs, i,rp-1-i);
                index = i;
                rp = i+dp[i];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    private static int getNum(char[] cs,  int i,int j) {
        int sum = 0;
        for (int l = i-j, r = i+j; l >= 0 && r < cs.length; l--, r++) {
            if (cs[l] == cs[r]) {
                sum++;
            } else {
                break;
            }
        }
        return sum;
    }

    private static char[] getStrin(String ss) {
        char[] s = ss.toCharArray();
        char[] cs = new char[ss.length() + (ss.length() +1)];
        for (int i = 0; i < cs.length; i++) {
            if (i % 2 == 1) {
                cs[i] = s[i / 2];
            } else {
                cs[i] = '#';
            }
        }
        return cs;
    }

}
