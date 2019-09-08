package com.interrator;

public class Code2 {
    public static void main(String [] ags){
        System.out.println(minCode("abcdeasebcfdsggf","cbegff"));
    }
    public static int minCode(String s1,String s2){
        int min = Integer.MAX_VALUE;
        int l=0,r=0,sum = s2.length();
        int[] dp = new int[256];
        char[] cs1 = s1.toCharArray();
        for (char c:s2.toCharArray()){
            dp[c]++;
        }
        while (l<s1.length()&&r<s1.length()){
            while (sum>0&&r<s1.length()){
                if(dp[cs1[r]]>=1){
                    dp[cs1[r]]--;
                    sum--;
                }else {
                    dp[cs1[r]]--;
                }
                r++;
            }
            if(sum==0){
                min=min>r-l?r-l:min;
            }

            while (sum<1&&l<s1.length()){
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
