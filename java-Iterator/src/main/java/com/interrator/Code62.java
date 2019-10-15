package com.interrator;

public class Code62 {
    public static void main(String[] ags) {
        System.out.println(getMinSum(new int[]{0, 1, 2, 3, 3, 3, 2, 2, 2, 2, 2, 1, 1}));
    }

    /**
     * 根据得分给孩纸分糖,同分数的一定要分的一样多,最少一个,
     * 分高的比两边低分的多
     * 时间复杂度O(N)
     * @param arr
     * @return
     */
    public static int getMinSum(int[] arr) {
        int index = getIndex1(arr, 0);
        int[] dp = getSum(arr, 0, index++);
        int res = dp[0];
        int lbase = 1;
        int same = 1;//高度相同的纪录
        while (index < arr.length) {
            if (arr[index] > arr[index - 1]) {
                res += ++lbase;
                same = 1;
                index++;
            } else if (arr[index] < arr[index - 1]) {
                int next = getIndex1(arr, index - 1);
                dp = getSum(arr, index - 1, next++);//同样高的index 左右半坡
                if (dp[1] < lbase) {
                    res = dp[0] - dp[1];
                } else {
                    res = -lbase * same + dp[0] + dp[1] * (same - 1);//自己带一个,去掉共用的那个点的值
                }
                lbase = 1;
                same = 1;
                index = next;
            } else {
                res += lbase;
                same++;
                index++;
            }
        }
        return res;
    }

    private static int[] getSum(int[] arr, int i, int j) {
        int lbase = 1;
        int sum = 0;
        for (int index = j - 1; index >= i; index--) {
            if (arr[index] == arr[index + 1]) {
                sum += lbase;
            } else {
                sum += ++lbase;
            }
        }
        return new int[]{sum, lbase};
    }

    private static int getIndex1(int[] arr, int i) {
        while (i < arr.length - 1) {
            if (arr[i] < arr[i + 1]) {
                return i;
            }
            i++;
        }
        return arr.length - 1;
    }
}
