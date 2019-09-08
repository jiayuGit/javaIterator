package com.interrator;


public class Code18 {
    public static void main(String[] ags) {
        //int[] arr = getIndexArr("abcabcd".toCharArray());
        //System.out.println(KMP("ashfbhxabcabcdadbr","abcabcd"));
        System.out.println(solution(8, 2));
        System.out.println(solutionDP(8, 2));
        System.out.println(solution2(8, 2));
    }

    /**
     * 摔碎棋子问题
     * @param nLevel
     * @param k
     * @return
     */
    public static int solution2(int nLevel, int k) {
        int[] dp1 = new int[nLevel + 1];
        int[] dp2 = new int[nLevel + 1];
        for (int i = 1; i < dp2.length; i++) {
            dp2[i] = i;
        }
        for (int i = 1; i < k + 1; i++) {
            int[] a = dp1;
            dp1 = dp2;
            dp2 = a;
            int index = 1;
            for (int j =1;j<dp1.length;j++){
                int min = Integer.MAX_VALUE;

                for (int m = index;m<=j;m++){
                    int cur = Math.max(dp1[m-1],dp2[j-m]);
                    if(cur<min){
                        index = m;
                        min=cur;
                    }
                }
                dp2[j] = min+1;
            }
        }
        return dp2[nLevel];
    }

    public static int solutionDP(int nLevel, int k) {
        int[][] dp = new int[nLevel + 1][k + 1];
        for (int i = 1; i < nLevel + 1; i++) {
            dp[i][1] = i;
        }
        for (int i = 1; i <= nLevel; i++) {

            for (int j = 2; j <= k ; j++) {
                int min = Integer.MAX_VALUE;
                for (int m = 1; m <i+1; m++) {
                    min = Math.min(min, Math.max(dp[m - 1][j - 1], dp[i - m][j]));
                }
                dp[i][j] = min + 1;
            }
        }
        return dp[nLevel][k];

    }

    public static int solution(int nLevel, int k) {
        if (nLevel < 1 || k < 1) {
            return 0;
        }
        return processl(nLevel, k);
    }

    private static int processl(int nLevel, int k) {
        if (nLevel == 0) {
            return 0;
        }
        if (k == 1) {
            return nLevel;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i != nLevel + 1; i++) {

            min = Math.min(min, Math.max(processl(i - 1, k - 1),
                    processl(nLevel - i, k)));
        }
        return min + 1;
    }

    /**
     * KPM
     *
     * @param s1
     * @param s2
     * @return
     */
    public static int KMP(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        int[] dp = getIndexArr(cs2);
        for (int i = 0, m = 0; i < s1.length(); ) {
            if (cs1[i] == cs2[m]) {
                i++;
                m++;
                if (m == s2.length()) {
                    return i - m;
                }
            } else if (dp[m] >= 0) {
                m = dp[m];
            } else {
                m = 0;
                i++;
            }
        }
        return -1;
    }

    private static int[] getIndexArr(char[] cs2) {
        int[] dp = new int[cs2.length];
        dp[0] = -1;
        dp[1] = 0;
        int index = 2;
        while (index < cs2.length) {
            int m = index - 1;
            if (cs2[dp[m]] == cs2[m]) {
                dp[index] = dp[m] + 1;
                index++;
            } else if (dp[dp[m]] > 0) {
                m = dp[dp[m]];
            } else {
                dp[index] = 0;
                index++;
            }
        }
        return dp;
    }

}
