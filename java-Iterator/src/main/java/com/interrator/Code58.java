package com.interrator;

public class Code58 {
    /**
     * 数字转化中文字符
     *
     * @param n
     * @return
     */
    public static String numTo99999999(int n) {
        if (n < 0 || n > 99999999) {
            return "";
        }
        if (n < 10000) {
            return numTo9999(n);
        }
        int m = n / 10000;
        int s = n % 10000;
        if (s > 1000) {
            return numTo9999(m) + "万" + numTo9999(s);
        } else if (s == 0) {
            return numTo9999(m) + "万";
        } else {
            return numTo9999(m) + "万零" + numTo9999(s);
        }
    }

    public static String numTo9999(int n) {
        if (n < 0 || n > 9999) {
            return "";
        }
        if (n < 1000) {
            return numTo999(n);
        }
        int m = n / 1000;
        int s = n % 1000;
        if (s > 100) {
            return numTo9(m) + "千" + numTo999(s);
        } else if (s < 100 && s > 0) {
            return numTo9(m) + "千零" + numTo999(s);
        } else {
            return numTo9(m) + "千";
        }
    }

    public static String numTo999(int n) {
        if (n < 0 || n > 999) {
            return "";
        }
        if (n < 100) {
            return numTo99(n, true);
        }
        int m = n / 100;
        if (n % 100 > 10) {
            return numTo9(m) + "百" + numTo99(n % 100, true);
        } else if (n % 10 > 0) {
            return numTo9(m) + "百零" + numTo9(n % 10);
        } else {
            return numTo9(m) + "百";
        }
    }

    public static String numTo99(int n, boolean bo) {
        if (n < 0 || n > 99) {
            return "";
        }
        int m = n / 10;
        if (m == 1 && bo) {
            return numTo9(n) + "一十" + numTo9(n % 10);
        }
        if (m == 1 && !bo) {
            return "十" + numTo9(n % 10);
        } else if (m == 0) {
            return numTo9(n % 10);
        } else {
            return numTo9(m) + "十" + numTo9(n % 10);
        }
    }

    public static String numTo9(int n) {

        if (n < 1 || n > 9) {
            return "";
        }
        String[] s = {"一", "二", "三", "四", "五", "六", "七", "八", "九"};
        return s[n - 1];
    }
}
