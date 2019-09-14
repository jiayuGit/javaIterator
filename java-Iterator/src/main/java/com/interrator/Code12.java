package com.interrator;

public class Code12 {
    public static void main(String[] ags){
        int[] arr = bbb(5,20);
        for (int a:arr){
            System.out.print(a+" ");
        }
    }

    /**
     * 往固定大小的容器里随机放入有序的数,在超过容器容量时,所有数被放入容器的概率一样
     * 时间复杂度O(N)
     * @param k
     * @param max
     * @return
     */
    public static int[] bbb(int k,int max){
        if(k<1||max<1){
            return null;
        }
        int[] arr = new int[Math.min(k,max)];
        int i = 0;
        for(;i<arr.length;i++){
            arr[i]=i+1;
        }
        for (;i<max;i++){
            if(aaa(i)<=k){
                arr[aaa(k)-1]=i+1;
            }
        }
        return arr;
    }
    public static int aaa(int a){
        return (int)(Math.random()*a+1);
    }


}
