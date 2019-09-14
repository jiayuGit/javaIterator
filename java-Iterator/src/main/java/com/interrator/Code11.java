package com.interrator;

public class Code11 {
    public static void main(String[] ags) {
        Integer[] arr = new Integer[]{1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9};
        leftUnique(arr);
        for (int a : arr) {
            System.out.print(a + " ");
        }
        String[] 颜色 = new String[]{"红", "蓝", "绿", "红", "蓝", "红", "蓝", "红", "蓝", "绿", "红", "蓝", "红", "蓝", "绿"};
        leftUniString(颜色);
        for (String s : 颜色) {
            System.out.print(s);
        }
    }

    /**
     * 把字符串中的三类字符分成三份,左中右个分成相同的字符
     * 时间复杂度O(N)
     *
     * @param ss
     */
    public static void leftUniString(String[] ss) {
        if (ss == null || ss.length < 2) {
            return;
        }
        int left = 0;//第二组字符的最左边界
        int right = ss.length - 1;
        for (int i = 0; i < right; ) {
            if (ss[i] == "红") {
                swap(ss, left++, i++);//把当前位置的字符换到第二组的最左边界,且下标都加一
            } else if (ss[i] == "绿") {
                swap(ss, right--, i);//把当前位置的字符换到第二组的最右边界,且当前下标加一,二组的最右边界减一
            } else {
                i++;//符合第二组的值当前位置加一
            }
        }
    }

    /**
     * 把有序可重复的递增数组变成从左到右递增不重复,其余的放右边
     * @param arr
     */
    public static void leftUnique(Integer[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = 0;
        int index = 1;
        while (index < arr.length) {
            if (arr[index] != arr[left]) {
                swap(arr, ++left, index++);
            } else {
                index++;
            }
        }
    }

    private static void swap(Object[] arr, int left, int index) {
        Object a = arr[left];
        arr[left] = arr[index];
        arr[index] = a;
    }
}
