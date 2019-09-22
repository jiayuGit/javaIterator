package com.interrator;

import java.util.*;


public class Code44 {
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
}
