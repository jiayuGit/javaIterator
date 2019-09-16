package com.interrator;

public class Code39 {
    public static void main(String[] ags) {
        int[][] arr = new int[][]{{0,1,1,1,1},{0,1,0,1,0},{0,1,1,1,1},{0,1,1,1,1},{0,1,0,1,1}};
        System.out.println(getMax(arr));

    }

    /**
     * 矩阵中能形成的最大正方形
     * 时间复杂度O(N*M)
     * @param arr
     * @return
     */
    public static int getMax(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int[][] arrX = new int[arr.length+1][arr[0].length + 1];
        int[][] arrY = new int[arr.length+1][arr[0].length + 1];
        setArrMaxXY(arr, arrX, arrY);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j]!=0){
                    max = Math.max(max, getXYMax(arr, i, j, arrX, arrY));
                }
            }
        }
        return max;
    }

    /**
     * 获得当前x,y点的右方和下方最长到达距离
     * 时间复杂度O(N*M)
     * @param arr
     * @param arrX
     * @param arrY
     */
    private static void setArrMaxXY(int[][] arr, int[][] arrX, int[][] arrY) {
        for (int i = arr[0].length - 1; i >= 0; i--) {
            for (int j = arr.length - 1; j >= 0; j--) {
                if(arr[i][j]==1){
                    arrX[i][j] = arrX[i][j+1]+1;
                    arrY[i][j] = arrY[i+1][j]+1;
                }else {
                    arrX[i][j]=0;
                    arrY[i][j]=0;
                }
            }
        }
    }

    /**
     * 获得当前位置能构成的最大正方形
     * 时间复杂度O(N)
     * @param arr
     * @param i
     * @param j
     * @param arrX
     * @param arrY
     * @return
     */
    private static int getXYMax(int[][] arr, int i, int j, int[][] arrX, int[][] arrY) {
        int minS = Math.min(arrX[i][j],arrY[i][j]);
        for(int d =minS;d>i;d-- ){
            if(Math.min(arrX[i+d-1][j],arrY[i][j+d-1])>=d){
                return d;
            }
        }
        return 1;
    }











}
