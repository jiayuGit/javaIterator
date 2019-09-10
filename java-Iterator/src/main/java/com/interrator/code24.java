package com.interrator;

public class code24 {
    public static void main(String[] ags) {
        System.out.println(printOdd(new int[]{5, 6, 1, 3, 4, 5, 4, 3, 6}));

    }

    /**
     * 找出一个唯一不重复的数
     * 时间复杂度O(N)
     * @param arr
     * @return
     */
    public static int printOdd(int[] arr) {
        int res = 0;
        for (int a : arr
        ) {
            res ^= a;//相同的二进制数 ~ 运算会得0
        }
        return res;//最后剩下的就是答案
    }
}
