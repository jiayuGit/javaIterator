package com.interrator;

public class Code28 {
    public static void main(String[] ags ){
        int[] arr = new int[]{-2, -2, -1, -1, 0, 1, 1, 1, 1, 1, 2, 2, 3, 4, 6, 8, 14,10};//12 22
        System.out.println(getMaxArr(arr));


    }
    /**
     * 最大连续累加和
     * 时间复杂度O(N)
     * @param arr
     * @return
     */
    public  static int getMaxArr(int[] arr){
        int max = arr[0];
        int sum = 0;
        for(int i = 1;i<arr.length;i++){
            sum = sum+arr[i]>0?sum+arr[i]:0;
            max = Math.max(arr[i],sum);
        }
        return max;
    }



}
