package com.interrator;

import java.util.Scanner;

public class Code48 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] arr = new int[len];
        for (int i = 0;i<len;i++){
            arr[i]=in.nextInt();
        }
        for (int i = 0;i<len;i++){
            String m = gerA(arr[i]);
            System.out.println(m);
        }
    }

    private static String gerA(int n) {
        String s = "";
        while (n>=9){
            n-=9;
            s="9"+s;
        }
        if(n>=0){
            s=n+s;
        }
        return s;
    }
}
