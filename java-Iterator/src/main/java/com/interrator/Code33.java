package com.interrator;

public class Code33 {
    public static void main(String[] ags ){
        int[] arr = new int[]{5,3,6,1,8,9,7,10};
        System.out.println(getMaxProduct(new double[]{-2.5,4,0,3,0.5,8,-1}));
    }

    /**
     * 数组中两个数乘积最大的值
     * 时间复杂度O(N)
     * @param arr
     * @return
     */
    public static Double getMaxProduct(double[] arr){
        if(arr==null){
            return null;
        }
        double max = arr[0];
        double min = arr[0];
        double res = Integer.MIN_VALUE;
        for(int i = 1;i<arr.length;i++){
            max = Math.max(max*arr[i],min*arr[i]);
            max = Math.max(max,arr[i]);
            min = Math.min(min*arr[i],max*arr[i]);
            min = Math.min(min,arr[i]);
            res = Math.max(max,res);
        }
        return res;
    }


}
