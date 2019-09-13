package com.interrator;

public class Code32 {
    public static void main(String[] ags ){
        int[] arr = new int[]{-2, -2, -1, -1, 0, 1, 1, 1, 1, 1, 2, 2, 3, 4, 6, 8, 14,10};//12 22
        swap(arr,0,arr.length-1);
        setArr(arr);
    }

    /**
     * 把数组中下标为偶数或者奇数的位置,对应设置为全是偶数或者全是奇数
     * 时间复杂度O(N)
     * @param arr
     */
    public static void setArr(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        int a = 0;
        int b = 1;
        int i = a;
        while(i<arr.length&&b<arr.length&&a<arr.length){
            if(arr[i]%2==0){
                if(i!=a) {
                    swap(arr, i, a);
                }
                a+=2;
                i = a;
            }else {
                if(i!=b) {
                    swap(arr,i,b);
                }
                b+=2;
                i=b;

            }
        }
    }

    private static void swap(int[] arr, int i, int b) {
        arr[i]=arr[i]^arr[b];
        arr[b] = arr[i]^arr[b];
        arr[i]=arr[i]^arr[b];
    }
}
