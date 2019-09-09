package com.interrator;

import java.util.Deque;
import java.util.LinkedList;

public class Code23 {
    public static void main(String[] ags) {
        for (int i : getIndex("ababc")
        ) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(minS(new String[]{"1", "3", "3", "3", "2", "3", "1"}, "4", "1"));
        System.out.println(getPalindromel("ABB15AVC"));
        System.out.println(maxLength("()()))()(()())"));
        System.out.println(getvalue("-3+(1*4)*5".toCharArray(),0)[0]);
        System.out.println(-1>>>30);
        System.out.println(~1);
    }

    public static int[] getvalue(char[] chars, int i) {

        Deque<String> deque = new LinkedList();
        int per = 0;
        while (i < chars.length && chars[i] != ')') {
            if (chars[i] >= '0' && chars[i] <= '9') {
                per = per * 10 + Integer.valueOf((chars[i]-'0'));
                i++;
            }else if(chars[i]!='('){
                addNum(deque,per);
                deque.addLast(String.valueOf(chars[i++]));
                per=0;
            }else {
                int[] as=getvalue(chars,i+1);
                per = as[0];
                i = as[1]+1;
            }
        }
        addNum(deque,per);
        return new int[]{getNum(deque),i};
    }

    private static int getNum(Deque<String> deque) {
        int sum = Integer.valueOf(deque.pollFirst());
        while (!deque.isEmpty()){

            String s = deque.pollFirst();
            int m = Integer.valueOf(deque.pollFirst());
            sum+="+".endsWith(s)?m:-m;
        }
        return sum;
    }

    private static void addNum(Deque<String> deque, int per) {
        if(!deque.isEmpty()){
            String s = deque.pollLast();
            if("+".equals(s)||"-".equals(s)){
                deque.addLast(s);
            }else {
                int i = Integer.valueOf(deque.pollLast());
                per = "*".equals(s)?i*per:i/per;
            }
        }
        deque.addLast(String.valueOf(per));
    }

    public static int maxLength(String s) {
        if (s == null && s.length() < 2) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int[] dp = new int[cs.length];
        int max = 0;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == ')' && i - dp[i - 1] - 1 >= 0 && cs[i - dp[i - 1] - 1] == '(') {
                dp[i] = dp[i - 1] + 2;
                if (i - dp[i - 1] - 2 >= 0) {
                    dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                }
                max = dp[i] > max ? dp[i] : max;
            }
        }
        return max;
    }

    public static String getPalindromel(String s) {
        if (s == null && s.length() < 2) {
            return s;
        }
        char[] cs = s.toCharArray();
        int[][] arr = getDP(s);
        char[] dp = new char[s.length() + arr[0][s.length() - 1]];
        for (int i = 0, j = s.length() - 1, l = 0, r = dp.length - 1; i <= j; )
            if (cs[i] == cs[j]) {
                dp[l++] = cs[i++];
                dp[r--] = cs[j--];
            } else {
                if (arr[i + 1][j] > arr[i][j - 1]) {
                    dp[r--] = cs[j];
                    dp[l++] = cs[j--];
                } else {
                    dp[l++] = cs[i];
                    dp[r--] = cs[i++];
                }
            }
        return String.valueOf(dp);
    }

    public static int[][] getDP(String s) {
        char[] cs = s.toCharArray();
        int[][] dp = new int[cs.length][cs.length];
        for (int i = 1; i < dp.length; i++) {
            dp[i - 1][i] = cs[i - 1] == cs[i] ? 0 : 1;
            for (int j = i - 2; j >= 0; j--) {
                if (cs[j] == cs[i]) {
                    dp[j][i] = dp[j + 1][i - 1];
                } else {
                    dp[j][i] = Math.min(dp[j + 1][i], dp[j][i - 1]) + 1;
                }

            }
        }
        return dp;
    }

    public static int minS(String[] s, String s1, String s2) {
        int min = Integer.MAX_VALUE;
        int m1 = -1;
        int m2 = -1;
        int[] dp1 = getIndex(s1);
        int[] dp2 = getIndex(s2);
        for (int i = 0; i < s.length; i++) {
            if (KMP(s[i], s1, dp1)!=-1) {
                m1 = i;
                if (m2 != -1) {
                    min = min > m1 - m2 ? m1 - m2 : min;
                }

            }
            if (KMP(s[i], s2, dp2)!=-1) {
                m2 = i;
                if (m1 != -1) {
                    min = min > m2 - m1 ? m2 - m1 : min;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static int KMP(String s, String s1, int[] dp) {
        char[] cs1 = s.toCharArray();
        char[] cs2 = s1.toCharArray();
        for (int i = 0, m = 0; i < s.length(); ) {
            if (cs1[i] == cs2[m]) {
                i++;
                m++;
                if (m == cs2.length) {
                    return i-m;
                }
            } else if (dp[m] > 0) {
                m = dp[m];
            } else if (dp[m] == 0) {
                m = 0;
            } else {
                m = 0;
                i++;
            }
        }
        return -1;
    }

    public static int[] getIndex(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 1) {
            return new int[]{-1};
        }
        char[] cs = s.toCharArray();
        int[] dp = new int[cs.length];
        dp[0] = -1;
        dp[1] = 0;
        int n = dp[1];
        for (int i = 2; i < dp.length; ) {
            if (cs[n] == cs[i - 1]) {
                dp[i] = ++n;
                i++;
            } else if (n > 0) {
                n = dp[n - 1];
            } else {
                n = 0;
                dp[i] = 0;
                i++;
            }
        }
        return dp;
    }
}

