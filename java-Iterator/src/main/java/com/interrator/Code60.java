package com.interrator;

public class Code60 {
    public static void main(String[] agrs){
        System.out.println(getMin(new int[]{5, 6, 7, 8, 9, 1, 2, 3}));
    }
    /**
     * 二分查找断层有序数组的最小值
     *
     * @param arr
     * @return
     */
    public static int getMin(int[] arr) {
        if (arr.length < 2) {
            return arr[0];
        }
        int left = 0;
        int right = arr.length - 1;
        int m = 0;
        while (left < right) {
            if (left == right - 1) {
                break;
            }
            if (arr[left] < arr[right]) {
                return arr[left];
            }
            m = (left + right) / 2;
            if (arr[left] > arr[m]) {
                right = m;
            } else if (arr[m] > arr[right]) {
                left = m;
            } else {
                while (left < m) {
                    if (arr[left] == arr[m]) {
                        left++;
                    } else if (arr[left] < arr[m]) {
                        return arr[left];
                    } else {
                        right = m;
                        break;
                    }
                }
            }
        }
        return Math.min(arr[left], arr[right]);
    }
}
