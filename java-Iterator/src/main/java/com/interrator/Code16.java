package com.interrator;


import java.util.Date;

/**
 * 二分查找两个数组长度不相等,数组内有序的中位数
 */
public class Code16 {
    public static void main(String[] ags){
        int[] a = new int[]{1,3,5,6};
        int[] b = new int[]{2,4};
        System.out.println(getNum(a,b));
        Date date = new Date();

    }
    public static double getNum(int[] a,int[] b){
        if(a.length>b.length){
            int[] m = a;
            a= b;
            b= m;
        }
        int left = 0;
        int right = a.length;
        int len = (a.length+b.length+1)>>>1;
        while (left<right){
            int i = (left+right)/2;
            int j = len-i;
            if(i>0&&a[i-1]<b[j]&&a[i]>b[j-1]){
                left = i;
                break;
            }else
            if(a[i]<b[j-1]){
                left = i+1;
            }else if(i>0&&a[i-1]>b[j]) {
                right = i-1;
            }else
            {
                    right = i;
            }
        }
        int i = left;
        int j = len - i;
        int lMax1 = i==0?Integer.MIN_VALUE:a[i-1];
        int rMin1 = i==a.length?Integer.MAX_VALUE:a[i];
        int lMax2 = j==0?Integer.MIN_VALUE:b[j-1];
        int rMin2 = j==b.length?Integer.MAX_VALUE:b[j];
        if(((a.length+b.length)&1)==1){
            return Math.max(lMax1,lMax2);
        }else {
            return (double)(Math.max(lMax1,lMax2)+Math.min(rMin1,rMin2))/2;
        }
    }
}
