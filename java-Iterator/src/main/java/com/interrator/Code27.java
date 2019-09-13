package com.interrator;

import java.util.Arrays;
import java.util.HashMap;

public class Code27 {
    public static void main(String[] ags) {


        int[] arr = new int[]{-2, -2, -1, -1, 0, 1, 1, 1, 1, 1, 2, 2, 3, 4, 6, 8, 14};
        Arrays.sort(arr);
        System.out.println(getIndex(arr, 6));
        System.out.println(getIndex1(arr,0,arr.length, 2));
    }

    /**
     * 二分法查找给定值
     * 时间复杂度O(log(N))
     * @param arr
     * @param left
     * @param right
     * @param k
     * @return 返回最终两个下标的左边的下标
     */
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
    /**
     * 二分法查找给定值
     * 时间复杂度O(log(N))
     * @param arr
     * @param k
     * @return 返回给定值的下标,如没有就返回-1
     */
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







}
