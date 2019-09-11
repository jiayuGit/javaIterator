package com.interrator;

import java.util.Arrays;

public class Code8 {
    public static void main(String[] ags){
        int[] arr = new int[]{5,9,4,2,7,-4,-6,-3,5,6,1,8,3,7};
        Arrays.sort(arr);
        pintArr(arr,8);
        System.out.println("---------------------");
        prinA(arr,9);
    }

    /**
     * 数组中三个数的和为国定值,且不重复打印
     * 时间复杂度O(N^2)
     * @param arr
     * @param k
     */
    public static void prinA(int[] arr,int k){
        for(int i = 0;i<arr.length;i++){
            if(i==0||arr[i]!=arr[i-1]){
                priA(arr,i,i+1,arr.length-1,k-arr[i]);
            }
        }
    }

    /**
     * 数组中两个数的和为固定值,且不重复打印
     * 时间复杂度O(N)
     * @param arr
     * @param i
     * @param left
     * @param right
     * @param k
     */
    private static void priA(int[] arr, int i, int left, int right, int k) {
        while(left<right){
            if(arr[left]+arr[right]>k){
                right--;
            }else if(arr[left]+arr[right]<k){
                left++;
            }else {
                if(left==i+1||arr[left-1]!=arr[left]){
                    System.out.println(arr[i]+" "+arr[left]+" "+arr[right]);
                }

                left++;
                right--;
            }
        }
    }

    public static void pintArr(int[] arr,int k){
        int left = 0;
        int right = arr.length-1;

        while(left<right){
            if(arr[left]+arr[right]>k){
                right--;
            }else if(arr[left]+arr[right]<k){
                left++;
            }else {
                if(left==0||arr[left-1]!=arr[left]){
                    System.out.println(arr[left]+" "+arr[right]);
                }
                left++;
                right--;

            }
        }
    }
}
