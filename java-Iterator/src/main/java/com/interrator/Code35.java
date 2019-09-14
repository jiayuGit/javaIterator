package com.interrator;

public class Code35 {
    public static void main(String[] ags){
        System.out.println(sssss(0,3,0,0,4,0,1,1));

    }
    /**
     * 点x,y是否在三角形内
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @param x
     * @param y
     * @return
     */
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

    /**
     * 向量2是否在向量1的左侧
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return 左侧时返回大于0的数,右侧时,返回小于0的数
     */
    public static double zuo(double x1,double y1,double x2,double y2){
        return x1*y2-x2*y1;
    }
}
