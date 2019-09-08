package com.interrator;

public class Code7 {
    public static void main(String [] ags){
        int[][] arr = new int[][]{{1,2,3,4},
                                    {5,6,7,8},
                                    {9,10,11,12}};
        prinArr(arr);
    }
    public static void  prinArr(int[][] arr){
        int lx = 0;
        int ly = 0;
        int rx = 0;
        int ry = 0;
        boolean b = true;
        while (lx!=arr[0].length-1||ly!=arr.length-1||
                rx!=arr[0].length-1||ry!=arr.length-1
                ){
            priA(arr,lx,ly,rx,ry,b);
            b=!b;
            if(ly!=arr.length-1){
                ly++;
            }else {
                lx++;
            }
            if(rx!=arr[0].length-1){
                rx++;
            }else {
                ry++;
            }

        }
    }

    private static void priA(int[][] arr, int lx, int ly, int rx, int ry, boolean b) {
        if(b){
            while (lx<=rx){
                System.out.print(arr[ly][lx]+" ");
                ly--;
                lx++;
            }
        }else {
            while (lx<=rx){
                System.out.print(arr[ry][rx]+" ");
                ry++;
                rx--;
            }
        }
    }


}
