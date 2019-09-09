package com.interrator;

public class Code2 {
    public static void main(String [] ags){
        System.out.println(minCode("abcdeasebcfdsggf","cbegff"));
    }

    /**
     * 字符串1中包含字符串2的所有字符的最小子串
     *时间复杂度O(N)
     * @param s1
     * @param s2
     * @return
     */
    public static int minCode(String s1,String s2){
        int min = Integer.MAX_VALUE;
        int l=0,r=0,sum = s2.length();
        int[] dp = new int[256];
        char[] cs1 = s1.toCharArray();
        for (char c:s2.toCharArray()){
            dp[c]++;
        }
        while (l<s1.length()&&r<s1.length()){
            while (sum>0&&r<s1.length()){//窗口右侧  sum==0时出现一个符合的字符,或者R到达右边界,右侧扩大,左侧不变
                if(dp[cs1[r]]>=1){
                    dp[cs1[r]]--;
                    sum--;
                }else {
                    dp[cs1[r]]--;
                }
                r++;
            }
            if(sum==0){//L-R完全包含时
                min=min>r-l?r-l:min;
            }

            while (sum<1&&l<r){//窗口左侧向右侧移动,sum<1为字符还被包含中,左侧缩小,右侧不变
                dp[cs1[l]]++;
                if(dp[cs1[l]]>=1){
                    sum++;
                }
                l++;
                if(sum>=0){
                    min=min>r-l?r-l:min;
                }
            }

        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
