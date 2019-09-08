package com.interrator;

public class Code12 {
    public static void main(String[] ags){
        System.out.println(sssss(0,3,0,0,4,0,1,1));
        int[] arr = bbb(5,20);
        for (int a:arr){
            System.out.print(a+" ");
        }
    }
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
    public static boolean sssss(double x1,double y1,double x2,double y2,double x3,double y3,double x,double y){
        if(zuo(x2-x1,y2-y1,x3-x1,y3-y1)<0){
            double temx = x2;
            double temy = y2;
            x2=x3;
            y2=y3;
            x3=temx;
            y3=temy;
        }
        if(zuo(x2-x1,y2-y1,x-x1,y-y1)<0){
            return false;
        }
        if (zuo(x3-x2,y3-y2,x-x2,y-y2)<0){
            return false;
        }
        if (zuo(x1-x3,y1-y3,x-x3,y-y3)<0){
            return false;
        }
        return true;
    }
    public static double zuo(double x1,double y1,double x2,double y2){
        return x1*y2-x2*y1;
    }
}
