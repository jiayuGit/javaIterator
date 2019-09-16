package com.interrator;

public class Code38 {
    public static void main(String[] ags) {
        int[][] arr = new int[][]{{219, 405, 538, 845, 971}, {148, 558}, {52, 99, 348, 691}};
        prinMaxK(arr, 11);
        System.out.println(arr);

    }

    /**
     * 多组有序递增的数组中连续打印K个数,从大到小打印
     * 时间复杂度O(K*log(N))
     * @param arr
     * @param k
     */
    public static void prinMaxK(int[][] arr, int k) {
        if (k <= 0) {
            return;
        }

        HeapMax[] heapMax = new HeapMax[arr.length];
        for (int i = 0; i < arr.length; i++) {
            heapMax[i] = new HeapMax(arr[i][arr[i].length - 1], i, arr[i].length - 1);
        }
        setHeap(heapMax);
        int len = arr.length - 1;
        for (int i = 0; i < k; i++) {
            len = prinMax(heapMax, len, arr);
        }
    }

    public static int prinMax(HeapMax[] heapMax, int len, int[][] arr) {
        System.out.println(heapMax[0].value);
        if (heapMax[0].index == 0) {
            swap(heapMax, 0, len);
            setMax(heapMax, 0, --len);
        } else {
            heapMax[0].value = arr[heapMax[0].arrIndex][--heapMax[0].index];
            setMax(heapMax, 0, len);
        }
        return len;
    }

    private static void swap(HeapMax[] heapMax, int i, int len) {
        HeapMax heap = heapMax[i];
        heapMax[i] = heapMax[len];
        heapMax[len] = heap;
    }

    private static void setHeap(HeapMax[] heapMax) {
        int m = heapMax.length / 2 - 1;
        while (m >= 0) {
            setMax(heapMax, m, heapMax.length);
            m--;
        }
    }

    private static void setMax(HeapMax[] heapMax, int m, int length) {
        HeapMax res = heapMax[m];
        int i = m * 2 + 1;
        while (i <= length) {
            if (i + 1 <= length && heapMax[i + 1].value > res.value && heapMax[i + 1].value > heapMax[i].value) {
                heapMax[m] = heapMax[++i];
                m = i;
                i = i * 2 + 1;
            } else if (heapMax[i].value > heapMax[m].value) {
                heapMax[m] = heapMax[i];
                m = i;
                i = 2 * i + 1;
            } else {
                break;
            }
        }
        heapMax[m] = res;
    }

    static class HeapMax {
        int value;
        int arrIndex;
        int index;

        public HeapMax(int value, int arrIndex, int index) {
            this.value = value;
            this.arrIndex = arrIndex;
            this.index = index;
        }
    }
}
