package com.interrator;

public class Code5 {
    public static void main(String[] ags) {
        sumNN(new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7});
    }

    public static int getSum(int[] arr) {

        int[] ends = new int[arr.length];
        int[] dp = new int[arr.length];
        int dps = 0;
        ends[0] = arr[0];
        dp[0] = 1;
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            int l = 0;
            int r = dps;

            while (l <= r) {
                m = (l + r) / 2;
                if (ends[m] < arr[i]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            ends[l] = arr[i];
            dps = Math.max(dps, l);
            dp[i] = l + 1;
        }
        return dp[dp.length - 1];
    }

    public static void sumD(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        int right = 0;
        ends[0] = arr[0];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int l = 0;
            int r = right;
            int m = 0;
            while (l <= r) {
                m = (l + r) / 2;
                if (ends[m] < arr[i]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = l > right ? l : right;
            dp[i] = l + 1;
            ends[l] = arr[i];
        }
        System.out.println(dp);
    }

    public static int[] sumNN(int[] arr) {
        int[] ends = new int[arr.length];
        int[] dp = new int[arr.length];
        int right = 0;
        int l = 0;
        int r = 0;
        ends[0] = arr[0];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            int m = 0;
            while (l <= r) {
                m = (l + r) / 2;
                if (ends[m] < arr[i]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }

            }
            ends[l] = arr[i];
            right = Math.max(right, l);
            dp[i] = l + 1;
            max = Math.max(dp[i], max);
        }
        int[] nums = new int[max];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (max > 0 && dp[i] == max) {
                nums[--max] = arr[i];
            }
        }
        return nums;
    }
}
