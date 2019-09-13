package com.interrator;

public class Code31 {
    public static void main(String[] ags ){


        int[][] ar = new int[][]{{-90,48,78},
                {64,-40,64},
                {-81,-7,66}};
        System.out.println(getMaxAB(ar));
    }
    /**
     *数组矩阵累加和最大
     * 时间复杂度
     * @param arr
     * @return
     */
    public static int getMaxAB(int[][] arr){
        int[] dp = null;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            dp = new int[arr[0].length];
            for(int j = i;j<arr.length;j++){
                max =Math.max(getMax(arr,j,dp),max) ;
            }
        }
        return max;
    }
    private static int getMax(int[][] arr, int j, int[] dp) {
        int max = 0;
        int cur = 0;
        for(int i = 0;i<dp.length;i++){
            dp[i]+=arr[j][i];
            cur += dp[i];
            max = Math.max(dp[i],max+dp[i]);
            cur = cur<0?0:cur;

        }
        return max;
    }
}
