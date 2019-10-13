package com.interrator;

public class Code59 {
    public static void main(String[] agrs){
        System.out.println(isNum(new int[]{5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 5}, 5));
    }
    /**
     * 二分查找断层有序数组某个数
     *时间复杂度O(Log(N))
     * @param arr
     * @param num
     * @return
     */
    public static boolean isNum(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int m = 0;
        while (left <= right) {
            m = (left + right) / 2;
            if (arr[m] == num) {
                return true;
            } else if (left == right) {
                return false;
            }
            if (arr[left] < arr[m]) {
                if (arr[left] <= num && arr[m] > num) {
                    right = m - 1;
                } else {
                    left = m + 1;
                }
            } else if (arr[m] < arr[right]) {
                if (arr[m] < num && arr[right] >= num) {
                    left = m + 1;
                } else {
                    right = m - 1;
                }
            } else {
                while (left < m) {
                    if (arr[left] == arr[m]) {
                        left++;
                    } else {
                        break;
                    }
                }
            }
        }
        return false;
    }

}
