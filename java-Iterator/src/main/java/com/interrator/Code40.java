package com.interrator;

public class Code40 {
    public static void main(String[] ags) {

        int[] ar = new int[]{2,3,0,1,2,4};
        for (int m : getMaxProdct(ar)){
            System.out.print(m+" ");
        }
        System.out.println();
        ;
        for (int m : getMaxProct2(ar)){
            System.out.print(m+" ");
        }
        System.out.println(getMaxABA("BDCABABACB"));
    }
    public static int getMaxABA(String s){
        char[] cs = s.toCharArray();
        int max = 1;
        boolean[][] dp = new boolean[cs.length][cs.length];
        for(int i = 0 ; i<cs.length;i++){
            dp[i][i]=true;
            for(int j = i-1;j>=0;j--){
                if(cs[j]==cs[i]){
                    if(j==i-1){
                        dp[j][i]=true;
                        max = Math.max(max,i-j+1);
                    }else if(dp[j+1][i-1]){
                        dp[j][i]=true;
                        max = Math.max(max,i-j+1);
                    }
                }
            }
        }
        return max;
    }
    /**
     * 获取不包含当前位置的乘积,包括零
     * 实际复杂度O(N)
     * @param arr
     * @return
     */
    public static int[] getMaxProct2(int[] arr){
        int[] res = new int[arr.length];
        int m = 1;
        res[0]=arr[0];
        for(int i =1;i<arr.length;i++){
            res[i]=res[i-1]*arr[i];
        }
        for(int i = arr.length-1;i>0;i--){
            res[i]=res[i-1]*m;
            m*=arr[i];
        }
        res[0]=m;
        return res;
    }

    /**
     * 获取不包含当前位置的乘积,不算零
     * 实际复杂度O(N)
     * @param arr
     * @return
     */
    public static int[] getMaxProdct(int[] arr){
        int[] dp = new int[arr.length];
        int res = 1;
        int count = 0;
        for(int m : arr){
            if(m!=0){
                res*=m;
            }else {
                count++;
            }
        }
        if(count>1){
            return dp;
        }
        for (int i = 0 ;i<arr.length;i++){
            if(arr[i]!=0){
                dp[i] = res/arr[i];
            }else {
                dp[i]=res;
            }

        }
        return dp;
    }









}
