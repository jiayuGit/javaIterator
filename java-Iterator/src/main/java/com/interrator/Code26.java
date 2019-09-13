package com.interrator;


import java.util.Arrays;
import java.util.HashMap;

public class Code26 {
    public static void main(String[] ags) {
        System.out.println(getMaxArr(new int[]{1, 2, 1, 1, 0, 1, 0, 0, 1, 0}, 3));

    }

    /**
     * 求在数组中累加和的最长子序列
     * 时间复杂度O(N)
     * @param arr
     * @param k
     * @return
     */
    public static int getMaxArr(int[] arr, int k) {
        int len = 0;
        int left = 0;//滑动窗口左侧
        int right = 0;//滑动窗口右侧
        int sum = arr[0];
        while (true) {
            if (sum < k) {//累加和小于给定值,右侧继续扩
                if (right + 1 == arr.length) {//滑动窗口到数组右边界
                    break;
                }
                sum += arr[++right];
            } else if (sum > k) {//累加和大于给定值,左侧前进,累加和减小
                sum -= arr[left++];
            } else {//累加和与给定值相等
                len = Math.max(len, right - left + 1);//统计累计和子序列最长长度
                sum -= arr[left++];//右侧移动一下,当前已经相等,需要开始下一阶段
                if (right + 1 == arr.length) {
                    break;
                }
                sum += arr[++right];//右侧移动一下,当前值已经小于累加和,然后纪录到累加和中,开始下一阶段
            }

        }
        return len;

    }


}
