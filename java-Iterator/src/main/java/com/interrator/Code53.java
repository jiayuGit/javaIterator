package com.interrator;

import java.util.HashMap;

import java.util.Map;

public class Code53 {
    public static void main(String[] args) {
        char c = getChar("fjfdhd112uii");
    }

    private static char getChar(String s) {
        Map<Integer,Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        int[] res = new int[256];
        for (char c:cs
             ) {
            res[c]++;
        }
        for (int i = cs.length-1;i>=0;i--) {
            if(res[cs[i]]==1){
                return cs[i];
            }
        }
        return 0;
    }

}
