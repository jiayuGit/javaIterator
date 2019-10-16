package com.interrator;

public class Code63 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 6, 3, 3, 3};
        setHeap(arr);
    }
    /**
     * 堆排序
     *时间复杂度O(N*log(N))
     * @param arr
     */
    public static void setHeap(int[] arr) {
        int m = arr.length / 2 - 1;//找到倒数第二层的最后一个值,加快构建小顶堆
        while (m >= 0) {
            setMax(arr, m, arr.length - 1);
            m--;
        }
        setArrXU(arr);
    }

    private static void setArrXU(int[] arr) {
        int len = arr.length - 1;
        while (len > 0) {
            swap(arr, 0, len);
            setMax(arr, 0, --len);
        }
    }


    private static void swap(int[] arr, int i, int len) {
        int a = arr[i];
        arr[i] = arr[len];
        arr[len] = a;
    }

    /**
     * 构建局部小顶堆m-len
     * @param arr
     * @param m
     * @param len
     */
    private static void setMax(int[] arr, int m, int len) {
        int res = arr[m];
        int index = m * 2 + 1;
        while (index <= len) {
            if (index + 1 <= len && res < arr[index + 1] && arr[index + 1] > arr[index]) {
                arr[m] = arr[index + 1];
                m = ++index;
                index = index * 2 + 1;
            } else if (arr[index] > res) {
                arr[m] = arr[index];
                m = index;
                index = 2 * index + 1;
            } else {
                break;
            }
        }
        arr[m] = res;
    }
}
