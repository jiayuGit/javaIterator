package com.interrator;

public class Code19 {
    public static void main(String[] ags) {
        System.out.println(getMinTime(new int[]{1, 1, 1, 4, 3}, 2));
        System.out.println(getMinTime2(new int[]{1, 1, 1, 4, 3}, 2));
        System.out.println(getMinTime3(new int[]{1, 1, 1, 4, 3}, 2));
        System.out.println(getMin(new long[]{2,1,3,2}));
    }

    public static int getMin(long[] arr) {
        long index = 0;
        int res = 0;
        for (int i = 0;i<arr.length;i++){
            if(index<i){
                res++;
            }
            for(int j = arr.length-1;j>index;j--){
                if(arr[i]>arr[j]){
                    index = j;
                    break;
                }
            }
        }
        return res+1;
    }

    public static int getMinTime3(int[] arr, int k) {
        if (k < 1) {
            return -1;
        }
        if (arr.length <= k) {
            int max = Integer.MIN_VALUE;
            for (int a : arr
                    ) {
                max = Math.max(max, a);
            }
            return max;
        }
        int sum = 0;
        for (int a : arr
                ) {
            sum += a;
        }
        int minSun = 0;
        int maxSum = sum;
        while (minSun != maxSum - 1) {
            int m = (maxSum + minSun) / 2;
            if (getSum(arr, m) > k) {
                minSun = m;
            } else {
                maxSum = m;
            }
        }
        return maxSum;
    }

    public static int getSum(int[] arr, int time) {
        int res = 1;
        int sum = 0;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] > time) {
                return Integer.MAX_VALUE;
            }
            sum += arr[i];
            if (sum > time) {
                res++;
                sum = arr[i];
            }
            i++;
        }
        return res;
    }

    public static int getMinTime2(int[] arr, int n) {
        int[][] dp = new int[n][arr.length];
        int[] sum = new int[arr.length];
        dp[0][0] = arr[0];
        sum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
            dp[0][i] = sum[i];
        }
        int[] dd = new int[arr.length];
        for (int i = 1; i < n; i++) {
            for (int j = i; j < arr.length; j++) {
                int index = dd[i];
                int min = Integer.MAX_VALUE;
                int len = j == arr.length - 1 ? j : dd[i + 1];
                for (int m = index; m < len; m++) {
                    int res = Math.max(dp[i - 1][m], sum[j] - sum[m]);

                    if (res < min) {
                        min = res;
                        dd[j] = m;
                    }
                }
                dp[i][j] = min;
            }
        }
        return dp[n - 1][arr.length - 1];
    }


    public static int getMinTime(int[] arr, int n) {
        int[] dp = new int[arr.length];
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        dp[0] = arr[0];
        for (int i = 1; i < sum.length; i++) {//一个画师做了一遍
            sum[i] = sum[i - 1] + arr[i];
            dp[i] = sum[i];
        }
        for (int i = 1; i < n; i++) {//减少一个
            for (int j = arr.length - 1; j >= i; j--) {
                int min = Integer.MAX_VALUE;
                for (int k = i - 1; k < j; k++) {
                    int res = Math.max(dp[k], sum[j] - sum[k]);
                    min = Math.min(min, res);
                }
                dp[j] = min;
            }
        }
        return dp[dp.length - 1];
    }
}
