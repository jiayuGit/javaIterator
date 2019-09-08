package com.interrator;

import java.util.HashMap;

public class Code20 {
    public static void main(String[] ags) {
        //System.out.println(getMin(new int[]{1, 2, 3, 4, 5, 1000}, 2));;
        HashMap map = new HashMap();
        A a = new A();
        a.value="a";
        A b = new A();
        b.value="b";
        map.put(a,"aaaaaaaa");
        map.put(b,"bbbbbbbb");
        System.out.println(map.get(a));
        System.out.println(map.get(b));
    }
    static class A{
        String value = null;

        @Override
        public String toString() {
            return "A{" +
                    "value='" + value + '\'' +
                    '}';
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return value.equals(obj);
        }
    }

    public static int getMin(int[] arr, int sum) {
        int[][] sumArr = new int[arr.length + 1][arr.length + 1];
        for (int i = 0; i < sumArr.length; i++) {
            for (int j = i + 1; j < arr.length ; j++) {
                sumArr[i][j] = sumArr[i][j - 1] + arr[j] - arr[(j + i) / 2];
            }
        }
        int[][] dp = new int[sum][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[0][i] = sumArr[0][i];
        }
        for (int i = 1; i < sum; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int min = Integer.MAX_VALUE;
                for (int m = 0; m <= j; m++) {
                    min = Math.min(min,dp[i - 1][m] + sumArr[m+1][j]);
                }
                dp[i][j] = min;
            }
        }
        return dp[sum-1][arr.length-1];
    }
}
