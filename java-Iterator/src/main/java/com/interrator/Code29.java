package com.interrator;

import java.util.HashMap;

public class Code29 {
    public static void main(String[] args) {
        System.out.println(getArr(new int[]{1, 2, 1, -1, 0, 1, 1, 1}, 3));
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
