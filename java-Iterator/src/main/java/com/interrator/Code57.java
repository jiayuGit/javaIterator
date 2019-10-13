package com.interrator;

public class Code57 {
    /**
     * 给定一个数组,数组下标为城市号,值为到首都路径上第一个相邻的城市,数组值和数组下标相同时为首都,
     * 城市与首都的距离,每种各有多少个
     * 时间复杂度O(N)
     * 空间复杂度1
     * @param arr
     */
    public static void pathsToDitans(int[] arr) {
        setPast(arr);
        setCounArr(arr);
    }

    /**
     *计算不同距离城市的个数
     * @param arr
     */
    private static void setCounArr(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {

            res = arr[i];
            if (res < 0) {
                arr[i] = 0;
                while (res < 0) {
                    int m = -res;
                    if (arr[m] < 0) {
                        res = arr[m];
                        arr[m] = 1;
                    } else {
                        arr[m]++;
                        break;
                    }
                }
            }
        }
        arr[0] = 1;
    }

    /**
     * 计算没个城市到首都的距离
     * @param arr
     */
    private static void setPast(int[] arr) {
        int pa = 0;
        int i = arr[0];
        arr[0] = -1;
        int d = 0;
        while (arr[i] >= 0 && arr[i] != i) {
            int p = arr[i];
            arr[i] = d;
            d = i;
            i = p;
        }
        pa = i;
        int res = -1;
        while (arr[d] >= 0) {
            int s = arr[d];
            arr[d] = res--;
            d = s;
        }
        arr[d] = res;
        for (int x = 1; x < arr.length; x++) {
            if (arr[x] >= 0) {
                int s = arr[x];
                if (pa != x) {
                    arr[x] = -1;
                }
                while (arr[s] >= 0 && arr[s] != s) {
                    int m = arr[s];
                    arr[s] = x;
                    x = s;
                    s = m;
                }
                s = arr[s] < 0 ? arr[s] : 0;
                while (arr[x] >= 0 && arr[x] != x) {
                    int m = arr[x];
                    arr[x] = --s;
                    x = m;
                }
                if (pa != x) {
                    arr[x] = --s;
                }
            }
        }
        arr[pa] = 0;

    }
}
