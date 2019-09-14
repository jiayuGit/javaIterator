package com.interrator;

public class Code36 {
    public static void main(String[] ags){
        System.out.println(getAB(new int[]{2,7,3,1,1}));
    }
    /**
     * 数组划分两部分,左边的最大值与右边的最大值的最大差值
     * @param arr
     * @return
     */
    public static int getAB(int[] arr){
        int[] ldp= new int[arr.length];
        int[] rdp = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            ldp[i]=max;
        }
        max = Integer.MIN_VALUE;
        for(int i = arr.length-1;i>=0;i--){
            max = Math.max(max,arr[i]);
            rdp[i]=max;
        }
        max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length-1;i++){
            int res = ldp[i]-rdp[i+1];
            res = res<0?-res:res;
            max = Math.max(max,res);
        }
        return max;
    }
}
