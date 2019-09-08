package com.interrator;

import java.util.Stack;

public class Code6 {
    public static void main(String[] ags){
            maxSum(new int[][]{{1,0,1,1}, {1,1,1,1},{1,1,1,0}});
            int i = 1;
        System.out.println(~-2);
        byte b = -128;
        System.out.println(Integer.MAX_VALUE-(b>>>1));
    }
    public static int maxSum(int[][] arr){
        int[][] por = new int[arr.length][arr[0].length];
        for (int i = 0 ;i<arr[0].length;i++){
            por[0][i]=arr[0][i];
        }
        for (int i = 1;i<arr.length;i++){
            for (int j = 0 ;j<arr[0].length;j++){
                if(arr[i][j]!=0){
                    por[i][j]=por[i-1][j]+arr[i][j];
                }
            }
        }
        return maxSS(por);
    }

    private static int getMaxArrSum(int[][] por) {
        int[] dp = new int[por[0].length];
        int right=0;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ;i<por.length;i++){
            dp[0]=0;
            right=0;
            for(int j=1;j<dp.length;j++){
                while(true){
                    if(por[i][dp[right]]>por[i][j]){
                        max = Math.max(por[i][dp[right]]*(j-(right-1<0?-1:dp[right-1])-1),max);

                        dp[right]=j;
                        right=right-1>=0?right-1:0;

                    }else if(por[i][dp[right]]==por[i][j]){
                        dp[right]=j;
                        break;
                    }else {
                        dp[++right]=j;
                        break;
                    }
                }
            }
            while (right>-1){
                max = Math.max(por[i][dp[right]]*(dp.length-(right-1<0?-1:dp[right-1])-1),max);
                right--;
            }
        }
        return max;
    }
    public static int maxSS(int[][] dp){
        Stack<Integer> stack =new Stack();
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<dp.length;i++){
            stack.add(0);
            for(int j = 1;j<dp[0].length;j++){
                while (true){
                    if(stack.isEmpty()){
                        stack.add(j);
                        break;
                    }else
                    if(dp[i][stack.peek()]>dp[i][j]){
                        max = Math.max(dp[i][stack.pop()]*(j-(stack.isEmpty()?-1:stack.peek())-1),max);

                    }else if(dp[i][stack.peek()]==dp[i][j]){
                        stack.pop();
                        stack.add(j);
                        break;
                    }else {
                        stack.add(j);
                        break;
                    }
                }

            }
            while (!stack.isEmpty()){
                max = Math.max(dp[i][stack.pop()]*(dp[0].length-(stack.isEmpty()?-1:stack.peek())-1),max);
            }
        }
        return max;
    }
}
