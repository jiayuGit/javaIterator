package com.interrator;

public class Code43 {
    public static void main(String[] args) {
        int[] dr = new int[]{1, 2, 3, 4, 5, 7, 6, 5, 4, 6, 10, 11};
        System.out.println(getMaxNum(dr));
    }

    /**
     * 数组中从1开始,连续的增长最大能到的值
     * 时间复杂度O(N)
     * @param arr
     * @return
     */
    public static int getMaxNum(int[] arr) {
        int l = 0;//连续的值已经到达的最大位置
        int r = arr.length;//能利用的值 的最大范围
        while (l < r) {
            if (arr[l] == l + 1) {//当前下标值,等于该下标对应应该到达的连续值
                l++;
            } else if (arr[l] < l + 1 || arr[l] > r || (arr[arr[l] - 1] == arr[l])) {//1.比当前小,2.比右边界大,3.当前位置的值,对应该放到对应下标的位置已经有符合的值
                arr[l] = arr[--r];//把不需要的值覆盖,缩小边界,把原边界的值放到当前位置
            } else {
                swap(arr, l, arr[l] - 1);
            }
        }
        return l + 1;
    }
    private static void swap(int[] arr, int l, int i) {
        arr[i] = arr[i] ^ arr[l];
        arr[l] = arr[i] ^ arr[l];
        arr[i] = arr[i] ^ arr[l];
    }
}
