package com.interrator;

public class Code56 {

    /**
     * 数组数值能连续最大累加和
     * 时间复杂度O(N*Log(N))
     * @param arr
     * @return
     */
    public static int getCountOne(int[] arr){
        guibing(arr,0,arr.length-1);
        int sum = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(sum+1<arr[i]){
                return sum+1;
            }else {
                sum+=arr[i];
            }
        }
        return sum+1;
    }

    /**
     * 归并排序
     * @param arr
     * @param i
     * @param j
     */
    private static void guibing(int[] arr, int i, int j) {
        int left = i;
        if(i>=j){
            return;
        }
        int m = (i+j)/2;
        guibing(arr,i,m);
        guibing(arr,m+1,j);
        int[] dp = new int[j-i+1];
        int x = 0;
        int s =m+1;
        while (i<=m&&s<=j){
            if(arr[i]>arr[s]){
                dp[x]=arr[s++];
            }else {
                dp[x]=arr[i++];
            }
            x++;
        }
        while (i<=m){
            dp[x++] = arr[i++];
        }
        while(s<=j){
            dp[x++]=arr[s++];
        }
        for (int k = 0;k<dp.length;k++){
            arr[left++] = dp[k];
        }
    }
}
