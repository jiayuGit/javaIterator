package com.interrator;


public class Code10 {
    public static void main(String[] ags) {
        int[] arr = new int[]{8,6,1,-3,4,9,-8,2,4};
        //setArrHeap(arr);
        heap(arr);
        for (int a:arr
        ) {
            System.out.print(a+" ");
        }
        System.out.println();
    }

    /**
     * 堆排序
     * 时间复杂度(N*log(N))
     * @param arr
     */
    public static void heap(int[] arr){
        int s = arr.length/2-1;
        while(s>=0){
            set(arr,s,arr.length);
            s--;
        }
        int len=arr.length-1;
        while (len>0){
            swap(arr,0,len);
            set(arr,0,len--);
        }
    }

    /**
     * 制定节点下落,直到平衡点
     * 时间复杂度O(log(N))
     * @param arr
     * @param i
     * @param length
     */
    private static void set(int[] arr, int i, int length) {
        int res = arr[i];
        int m = i*2+1;
        while(m<length){
            if(m+1<length&&arr[m+1]>res&&arr[m+1]>=arr[m]){
                arr[i]=arr[++m];
                i=m;
                m=m*2+1;
            }else if(arr[m]>res){
                arr[i]=arr[m];
                i=m;
                m=m*2+1;
            }else {
                break;
            }
        }
        arr[i]=res;
    }

    private static void setArrHeap(int[] arr) {
        createHaep(arr);
        int len = arr.length - 1;
        while (len > 0) {
            swap(arr, 0, len);
            setMax(arr,0,len--);
        }
    }

    private static void setMax(int[] arr, int i, int i1) {
        int res = arr[i];
        int m = i*2+1;
        while (m<i1){
            if(m+1<i1&&arr[m+1]>res&&arr[m+1]>=arr[m]){
                arr[i] = arr[m+1];
                i=++m;
                m=m*2+1;
            }else if(arr[m]>res){
                arr[i]=arr[m];
                i=m;
                m=m*2+1;
            }else {
                break;
            }
        }
        arr[i]=res;

    }

    private static void swap(int[] arr, int i, int len) {
        arr[i] = arr[i] ^ arr[len];
        arr[len] = arr[i] ^ arr[len];
        arr[i] = arr[i] ^ arr[len];
    }

    public static void createHaep(int[] arr) {
        int m = arr.length / 2 - 1;
        for (; m >= 0; m--) {
            setMax(arr, m);
        }
    }

    private static void setMax(int[] arr, int m) {
        int res = arr[m];
        for (int i = m * 2 + 1; i < arr.length; ) {
            if (i + 1 < arr.length && arr[i + 1] > res) {
                arr[m] = arr[i + 1];
                m = ++i;
                i = i * 2 + 1;
            } else if (arr[i] > res) {
                arr[m] = arr[i];
                m = i;
                i = i * 2 + 1;
            } else {
                break;
            }
        }
        arr[m] = res;
    }
}
