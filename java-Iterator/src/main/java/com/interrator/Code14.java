package com.interrator;

public class Code14 {
    public static void main(String[] ags) {
        System.out.println(getString(new char[]{'A','B','C','D'},32 ));
    }


    /**
     * 把数字转换成对应字符表示
     * @param cs
     * @param n
     * @return
     */
    public static String getString(char[] cs, int n) {
        int k = cs.length;
        int count = 0;
        int sum = 1;
        while (n >=sum) {
            n -= sum;
            sum *= k;
            count++;
        }
        int[] dp = new int[count];
        int left = 0;
        while (left<dp.length) {
            sum /= k;
            dp[left++] = 1 + n / sum;
            n = n%sum;
        }
        System.out.println(dp);

        return null;
    }
}
