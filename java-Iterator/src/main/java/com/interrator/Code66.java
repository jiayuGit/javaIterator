package com.interrator;

public class Code66 {
    public static void main(String[] ags) {
        int[] s1 = new int[]{1,3,6,9,10};
        int[] s2 = new int[]{2,4,5};
        System.out.println(getMedian(s1,s2));
    }

    /**
     * 寻找两个有序数组的中位数   二分法
     * @param a
     * @param b
     * @return
     */
    public static double getMedian(int[] a, int[] b) {
        if (a.length > b.length) {
            int[] s = a;
            a = b;
            b = s;
        }
        int i = 0;
        int left = 0;
        int right = a.length;
        int len = (a.length + b.length + 1) >>> 1;//多出一个
        int j = 0;
        while (left < right) {
            i = (left + right) / 2;
            j = len - i;
            if (a[i] < b[j - 1]) {
                left = i + 1;
            }else {
                right = i;
            }
        }
        i = left;
        j = len - i;
        int lMax1 = i == 0 ? Integer.MIN_VALUE : a[i - 1];
        int rMin1 = i==a.length? Integer.MAX_VALUE:a[i];
        int lMax2 =j==0?Integer.MIN_VALUE : b[j - 1];
        int rMin2 = j==b.length?Integer.MAX_VALUE:b[j];
        if(((a.length+b.length)&1)==1){
            return(double) Math.max(lMax1,lMax2);
        }else {
            return (double) (Math.max(lMax1,lMax2)+Math.min(rMin1,rMin2))/2;
        }
    }
}
