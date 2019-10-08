package com.interrator;

import java.util.Scanner;

public class Code49 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int sum = getSum(0,0,n,m);
        System.out.println(sum);
    }

    private static int getSum(int i, int j, int n, int m) {
        if(i==n-1||j==m-1){
            return 1;
        }
        int sum = getSum(i+1,j,n,m);
        sum = sum+getSum(i,j+1,n,m);
        return sum;
    }
}
