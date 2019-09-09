package com.interrator;

import java.util.Scanner;

public class Code4 {
    public static void main(String[] ags) {
        System.out.println(getSuS("abcdas", "ab.d.*"));
        prin(new int[]{1, 5, 1, 5, 4, 2, 3, 5, 8, 6});
        System.out.println("----------------------");
        System.out.println(sumN(new int[]{50, 48}));
        System.out.println(minArr(new int[]{1, 4, 3, 2, 5}, 1, 0));
    }

    public static int minArr(int[] arr, int n, int h) {
        if (h >= arr.length - 1) {
            return 0;
        }
        if (arr[h + 1] > n) {
            return minArr(arr, arr[h + 1], h + 1);
        } else if (arr[h + 1] == n) {
            return minArr(arr, n + 1, h + 1) + 1;
        } else {
            return Math.min(minArr(arr, n + 1, h + 1) + n - arr[h],
                    minArr(arr, n - 1, h + 1) + n - arr[h]);
        }

    }

    public static int minS() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.next());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(sc.next());
        }
        int[] dp = new int[n];
        //for ()
        return 0;
    }

    public static int sumN(int[] arr) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] * 1.0 >= 0.9 * arr[j] || 0.9 * arr[i] >= arr[j] * 1.0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    /**
     *
     * @param arr
     */
    public static void prin(int[] arr) {

        int min = Integer.MAX_VALUE;
        int letf = -1;
        int right = -1;
        for (int i = 1; i < arr.length; i++) {
            int m = arr[i - 1] - arr[i];
            m = m > 0 ? m : -m;
            if (m < min) {
                min = m;
                letf = i - 1;
                right = i;
            }

        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        if (letf != -1 && right != -1) {
            System.out.println(arr[letf] + " " + arr[right]);

        }
    }

    public static boolean isMathDP(String str, String exp) {
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        boolean[][] dp = initDpMap(s, e);
        for (int i = s.length - 1; i >= 0; i--) {
            for (int j = e.length - 2; j >= 0; j--) {
                if (e[j + 1] != '*') {
                    dp[i][j] = (e[j] == s[i] || e[j] == '.') && dp[i + 1][j + 1];
                } else {
                    int res = i;
                    while (res < s.length && (e[j] == s[res] || e[j] == '.')) {
                        if (dp[res][j + 2]) {
                            dp[i][j] = true;
                            break;
                        }
                        res++;
                    }
                    if (!dp[i][j]) {
                        dp[i][j] = dp[res][j + 2];
                    }
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 按规则,是否匹配字符串
     *时间复杂度O(N*M)
     * @param s1
     * @param eps
     * @return
     */
    public static boolean getSuS(String s1, String eps) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = eps.toCharArray();
        boolean[][] dp = initDpMap(cs1, cs2);
        for (int i = cs1.length - 1; i >= 0; i--) {
            for (int j = cs2.length - 2; j >= 0; j--) {
                if (cs2[j + 1] != '*') {
                    dp[i][j] = cs1[i] == cs2[j] || cs2[j] == '.';
                } else {
                    int res = i;
                    while (res < cs1.length && (cs1[res] == cs2[j] || cs2[j] == '.')) {
                        if (dp[res + 1][j + 2]) {
                            dp[i][j] = true;
                            break;
                        }
                        res++;
                    }
                    if (!dp[i][j]) {
                        dp[i][j] = dp[i][j + 2];
                    }
                }
            }
        }
        return dp[0][0];
    }

    private static boolean[][] initDpMap(char[] s, char[] e) {
        boolean[][] dp = new boolean[s.length + 1][e.length + 1];
        int sl = s.length;
        int el = e.length;
        dp[sl][el] = true;
        for (int i = el - 2; i >= 0; i--) {
            if (e[i] != '*' && e[i + 1] == '*') {
                dp[sl][i] = true;
            } else {
                break;
            }
        }
        //if(sl>0&&el>0){
        if (s[sl - 1] == e[el - 1] || e[el - 1] == '.') {
            dp[sl][el] = true;
        }
        //}
        return dp;
    }
}
