package com.interrator;

public class Code28 {
    public static void main(String[] ags ){
        int[] arr = new int[]{-2, -2, -1, -1, 0, 1, 1, 1, 1, 1, 2, 2, 3, 4, 6, 8, 14,10};//12 22
        System.out.println(getMaxArr(arr));
        System.out.println(getMax(new int[][]{arr},0,new int[arr.length]));
        swap(arr,0,arr.length-1);
        setArr(arr);

        int[][] ar = new int[][]{{-90,48,78},
                                 {64,-40,64},
                                 {-81,-7,66}};
        System.out.println(getMaxAB(ar));
        System.out.println();
        arr = new int[]{5,3,6,1,8,9,7,10};
        System.out.println(getMinArr(arr));
        System.out.println(getMaxProduct(new double[]{-2.5,4,0,3,0.5,8,-1}));
    }
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
        return m;
    }
    public static int getMaxAB(int[][] arr){
        int[] dp = null;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            dp = new int[arr[0].length];
            for(int j = i;j<arr.length;j++){
                max =Math.max(getMax(arr,j,dp),max) ;
            }
        }
        return max;
    }

    private static int getMax(int[][] arr, int j, int[] dp) {
        int max = 0;
        int cur = 0;
        for(int i = 0;i<dp.length;i++){
            dp[i]+=arr[j][i];
            cur += dp[i];
            max = Math.max(dp[i],max+dp[i]);
            cur = cur<0?0:cur;

        }
        return max;
    }

    /**
     * 最大连续累加和
     * 时间复杂度O(N)
     * @param arr
     * @return
     */
    public  static int getMaxArr(int[] arr){
        int max = arr[0];
        for(int i = 1;i<arr.length;i++){
            max = Math.max(arr[i],arr[i]+max);
        }
        return max;
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
