package com.interrator;

import java.util.Arrays;
import java.util.HashMap;

public class Code27 {
    public static void main(String[] ags) {
        System.out.println(getArr(new int[]{1, 2, 1, -1, 0, 1, 1, 1}, 3));
        System.out.println(getOrArr(new int[]{1,2, 1, -1, 0,2, 1, 1, 1, -2, 1}, 3));
        int[] arr = new int[]{-2, -2, -1, -1, 0, 1, 1, 1, 1, 1, 2, 2, 3, 4, 6, 8, 14};
        Arrays.sort(arr);
        System.out.println(getIndex(arr, 6));
        System.out.println(getIndex1(arr,0,arr.length, 2));
    }

    public static int getIndex1(int[] arr, int left, int right, int k) {
        int m = 0;
        int res = -1;
        while (left <= right) {
            m = (left + right) / 2;
            if (arr[m] <= k) {
                res = m;
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        return res;
    }

    public static int getIndex(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int m = 0;
        int res = -1;
        while (left <= right) {
            m = (left + right) / 2;
            if (arr[m] > k) {
                right = m - 1;
            } else if (arr[m] < k) {
                left = m + 1;
            } else {
                res = m;
                break;
            }
        }
        return res;
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

    /**
     * 数组中连续子序列的累加和为固定值时,最长连续子序列长度
     * 时间复杂度O(N)
     * 空间复杂度N
     * @param arr
     * @param k
     * @return
     */
    public static int getArr(int[] arr, int k) {
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//记录累加和出现才数组的最早位置
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {//判断当前数组下标位置之前,是否有符合累加和段
                len = Math.max(i - map.get(sum - k), len);
            }
            if (!map.containsKey(sum)) {//记录最早出现累加和与出现的下标
                map.put(sum, i);//该累加和不在map中才添加
            }
        }
        return len;
    }


}
