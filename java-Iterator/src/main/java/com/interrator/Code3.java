package com.interrator;

public class Code3 {
    public static void main(String[] ags) {
        System.out.println(minSS("ACDCDCAD"));
    }

    /**
     * 插入最少字符能让字符串成为回文串
     * 时间复杂度O(N^2)
     * @param s
     * @return
     */
    public static int minSS(String s){
        char[] cs = s.toCharArray();
        boolean[][] por = new boolean[cs.length][cs.length];//是否能成为回文串
        int[] dp = new int[cs.length+1];
        dp[cs.length]=-1;
        for(int i=cs.length-1;i>=0;i--){//右侧开始一段一段的,来建立每一段的最优解
            dp[i] = Integer.MAX_VALUE;
            for(int j = i;j<cs.length;j++){
                if(cs[i]==cs[j]&&(j-i<2||por[i+1][j-1])){
                    por[i][j]=true;
                    dp[i]=Math.min(dp[i],dp[j+1]+1);
                }
            }
        }
        return dp[0];
    }
//    public static int minCut(String s) {//不完整
//        char[] cs = s.toCharArray();
//        boolean[][] por = new boolean[s.length()][s.length()];
//        int[] dp = new int[s.length() + 1];
//        dp[s.length()] = -1;
//        for (int i = cs.length - 1; i >= 0; i--) {
//            dp[i] = Integer.MAX_VALUE;
//            for (int j = i; j < cs.length; j++) {
//                if (cs[i] == cs[j]&&(j-i<2||por[i + 1][j - 1])) {
//                    por[i][j] = true;
//                    //dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
//                }
//            }
//            for (int j = i; j < cs.length; j++) {
//                if (por[i][j]) {
//                    //por[i][j] = true;
//                    dp[i]=Math.min(dp[i],dp[j+1]+1);
//                }
//            }
//
//        }
//        return dp[0];
//    }
//
//    public static int minSu(String s) {
//        char[] cs = s.toCharArray();
//        int[] dp = new int[s.length() + 1];
//        boolean[][] por = new boolean[cs.length][cs.length];
//        dp[cs.length]=-1;
//        for (int i = cs.length - 1; i >= 0; i--) {
//            dp[i]= Integer.MAX_VALUE;
//            for (int j = i; j < cs.length; j++) {
//                if (cs[i] == cs[j] && (j - i < 2 || por[i + 1][j - 1])) {
//                    por[i][j] = true;
//                    dp[i]=Math.min(dp[i],dp[j+1]+1);
//                }
//            }
//        }
//        return dp[0]==Integer.MAX_VALUE?-1:dp[0];
//    }

}
