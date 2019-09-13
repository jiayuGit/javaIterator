package com.interrator;

public class Code34 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,6,1,8,9,7,10};
        System.out.println(getMinArr(arr));
    }
    /**
     * 在数组中找到一个局部最低点
     * 时间复杂度O(log(N))
     * @param arr
     * @return
     */
    public static int getMinArr(int[] arr){
        if(arr==null){
            return -1;
        }
        if(arr.length==1||arr[0]<arr[1]){
            return 0;
        }
        if(arr[arr.length-1]<arr[arr.length-2]){
            return arr.length-1;
        }
        int left = 0;
        int right = arr.length-1;
        int m = 0;
        int res = -1;
        while(left<=right){
            m = (left+right)/2;
            if(arr[m]>arr[m-1]){
                right = m-1;
            }else if(arr[m]>arr[m+1]){
                left = m+1;
            }else {
                res=m;
                break;
            }
        }
        return res;
    }
}
