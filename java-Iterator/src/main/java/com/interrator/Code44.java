package com.interrator;

import java.util.*;


public class Code44 {
//    public static void main(String[] ags) {
//               for(int i =0;i<10;i++)
    /**
     * 数组逆序差值和
     * 时间复杂度O(N^2)
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[][] arr = new int[sc.nextInt()][2];


        for(int i = 0;i<arr.length;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map  = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            if(set.contains(arr[i][0])){
                sum++;
            }else {
                set.add(arr[i][0]);
            }
            if(set.contains(arr[i][1])){
                sum++;
            }else {
                set.add(arr[i][1]);
            }
        }
        System.out.println(s-sum);;
        for(int i =0;i<10;i++)
            System.out.print(getRandomByRandTomM(7,5)+" ");
        System.out.println();
    }

    private static int getMinAAAA(int[] arr, int m) {
        int min = Integer.MAX_VALUE;


            int sum = 0;
            for(int j = 0;j<m;j++){
                sum+=arr[j];
            }

            for(int k = m,l=0;k<arr.length;){
                min = Math.min(min,sum);
                if(k-l>m&&sum-arr[l]>=sum+arr[k]){
                    sum = sum+arr[k];
                    k++;
                }else if(sum-arr[l]<sum+arr[k]){
                    sum =sum-arr[l];
                    l++;
                }else {
                    sum =sum+arr[k]-arr[l];
                    k++;
                    l++;
                }


            }


        return min;
    }


    /**
     * 从给定能生成1-m的随机数的基础上,设计生成随机数是1-n的范围
     *
     * @param m
     * @param n
     * @return
     */
    public static int getRandomByRandTomM(int m, int n) {
        int res = 0;
        if (m < n) {
            int s =((m * m ) - (m * m) % n)-1;
            do {
                res = (randTomM(m) - 1) * m + randTomM(m) - 1;
            } while (res > s);
        } else {

            do {
                res = randTomM(m);
            } while (res > n);
        }
        return res % n + 1;
    }

    public static int randTomM(int m) {
        return (int) (Math.random() * m + 1);
    }
}
