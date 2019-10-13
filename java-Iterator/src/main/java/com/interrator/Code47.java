package com.interrator;

import java.util.Scanner;

public class Code47 {
    /**
     * 获取逆序差值和
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] arr = new int[len];
        for(int i = 0;i<len;i++){
            arr[i]=in.nextInt();
        }
        int sum = 0;
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<len;j++){
                if(arr[i]>arr[j]){
                    sum+=(j-i);
                }
            }
        }
        System.out.println(sum);
    }
}
