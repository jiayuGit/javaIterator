package com.interrator.aa.bb;

import com.interrator.aa.A;

import java.util.*;


public class B {
    public static void main(String[] arg) {
        A a = new A();
        List list = new ArrayList();
        Map map = new HashMap();
        "aa".toCharArray();
        System.out.println(" ".length());
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(getMadianArr(new int[]{1,2,4},new int[]{-1,3,5,6}));

    }
    public static double getMadianArr(int[] a,int[] b){
        if(a.length>b.length){
            int[] s = a;
            a = s;
            b = a;
        }
        int k = (a.length+b.length+1)/2;
        if(a.length>=k){
            return getMedian(a,0,k-1,b,0,k-1);
        }else if(b.length<k){
            int m = a.length+b.length-k;
            if(a[b.length-k-1]>=b[b.length-1]){
                return a[k-b.length-1];
            }
            if(a[a.length-1]<=b[a.length-k-1]){
                return b[k-a.length-1];
            }
            return getMedian(a,b.length-m,a.length-1,b,k-a.length-m,b.length-1);
        }else {
            int m = k-a.length;
            if(b[m-1]>=a[a.length-1]){
                return b[m-1];
            }
            return getMedian(a,0,a.length-1,b,m,m+a.length-1);
        }
    }

    public static double getMedian(int[] a, int ai, int aj, int[] b, int bi, int bj) {
        if(a[aj]<=b[bi]||a[ai]>=b[bj]){
            return Math.min(a[aj],b[bj]);
        }
        while (ai != aj) {
            int m1 = (ai + aj) / 2;
            int m2 = (bi + bj) / 2;
            int off = ((aj - ai + 1) & 1) ^ 1;
            if (a[m1] > b[m2]) {
                aj = m1;
                bi = m2 + off;
            } else if (a[m1] < b[m2]) {
                ai = m1 + off;
                bj = m2;
            }else {
                return a[m1];
            }
        }
        return Math.min(a[ai], b[bi]);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        char[] res = s.toCharArray();
        int max = Integer.MIN_VALUE;
        int right = 0;
        int left = 0;
        int num = 0;
        while (right < res.length) {
            if (set.contains(res[right])) {
                set.remove(res[left]);
                num--;
                left++;
            } else {
                num++;
                set.add(res[right]);
                right++;
                max = Math.max(max, num);
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
