package com.interrator;

public class KMP {
        public static void main(String[] ags){
             System.out.println(getKMP("abababca", "ababc", getIndex("ababc")));
        }

    /**
     * 查找字符串1中是否有字符2
     * 时间复杂度O(N+M)
     * @param s
     * @param s1
     * @param dp
     * @return
     */
    private static boolean getKMP(String s, String s1, int[] dp) {
        char[] cs1 = s.toCharArray();
        char[] cs2 = s1.toCharArray();
        for (int i = 0, m = 0; i < s.length(); ) {
            if (cs1[i] == cs2[m]) {
                i++;
                m++;
                if (m == cs2.length) {
                    return true;
                }
            } else if (dp[m] > 0) {
                m = dp[m];
            } else if (dp[m] == 0) {
                m = 0;
            } else {
                m = 0;
                i++;
            }
        }
        return false;
    }
    public static int[] getIndex(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 1) {
            return new int[]{-1};
        }
        char[] cs = s.toCharArray();


        int[] dp = new int[cs.length];
        dp[1] = 0;
        dp[0] = -1;
        int n = dp[1];
        for (int i = 2; i < dp.length; ) {
            if (cs[n] == cs[i - 1]) {
                dp[i] = n+1;
                n++;
                i++;
            } else if (n > 0) {
                n = dp[n - 1];
            } else {
                n = 0;
                dp[i] = 0;
                i++;
            }
        }
        return dp;
    }
}
