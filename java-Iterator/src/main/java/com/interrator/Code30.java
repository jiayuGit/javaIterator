package com.interrator;



public class Code30 {
    public static void main(String[] ags) {

        System.out.println(getOrArr(new int[]{1,2, 1, -1, 0,2, 1, 1, 1, -2, 1}, 3));

    }
    /**
     *小于等于给定值的最长累加和的长度
     * 时间复杂度O(N*log(N))
     * 空间复杂度N
     * @param arr
     * @param k
     * @return
     */
    public static int getOrArr(int[] arr, int k) {
        int len = 0;
        int sum = 0;
        int[] res = new int[arr.length];//0-i的累加和
        int[] dp = new int[arr.length];//0-i中累加和的最大值
        dp[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            res[i] = sum;
            dp[i] =max = Math.max(max, sum);
        }
        for (int i = 0; i < arr.length; i++) {
            int ind = getIndex(dp, 0, i, res[i] - k);//查找大于res[i]-k的值的下标,说明去掉这一部分后说明ind-i的累加和小于等于K
            if (ind != -1) {
                len = Math.max(len, i - ind );
            }
        }
        return len;
    }
    /**
     * 在有序数组中查找大于等于定值的最左下标
     * 时间复杂度O(log(N))
     * 使用二分法查找
     * @param dp
     * @param l
     * @param r
     * @param k
     * @return
     */
    private static int getIndex(int[] dp, int l, int r, int k) {
        int m = 0;
        int res = -1;
        while (l <= r) {
            m = (l + r) / 2;
            if (dp[m] >= k) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }

}
