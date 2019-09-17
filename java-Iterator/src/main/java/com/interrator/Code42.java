package com.interrator;

public class Code42 {
    public static void main(String[] args) {
        int[] dr = new int[]{1,  3, 4, 5, 7, 6, 5, 4, 6, 10, 11};
        System.out.println(getMaxGap(dr));
        for (int a : dr
        ) {
            System.out.print(a + " ");
        }
        System.out.println(dr);
    }

    /**
     * 获取数组排序两个元素的最大差值
     * 时间复杂度O(N)
     * @param arr
     * @return
     */
    public static int getMaxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        if (min == max) {
            return 0;
        }
        int res = 0;
        boolean[] hasNum = new boolean[arr.length + 1];//生成比数组长度n+1的桶,把n个值放进n+1哥桶中,一定有一个是为空桶
        int[] mins = new int[arr.length + 1];//当前桶的最小值
        int[] maxs = new int[arr.length + 1];//当前桶的最大值
        for (int i = 0; i < arr.length; i++) {
            int num = getNum(arr[i], arr.length, min, max);//获取当前值应该放到桶的位置
            maxs[num] = hasNum[num] ? Math.max(maxs[num], arr[i]) : arr[i];
            mins[num] = hasNum[num] ? Math.min(mins[num], arr[i]) : arr[i];
            hasNum[num] = true;//标记桶有值
        }
        int r = 0;
        while (r < arr.length) {//获取第一个空桶的位置
            if (hasNum[r]) {
                break;
            }
            r++;
        }
        for (int i = r + 1; i < maxs.length; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - maxs[r]);
                r = i;
            }
        }
        return res;
    }

    /**
     * 求给定值,应该放到桶的下标
     * @param a
     * @param len
     * @param min
     * @param max
     * @return
     */
    private static int getNum(long a, long len, long min, long max) {
        int num = (int) ((a - min) * len / ((max - min)));
        return num;
    }
}
