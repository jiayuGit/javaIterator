package com.interrator;

public class Code44 {
    public static void main(String[] ags) {
               for(int i =0;i<10;i++)
            System.out.print(getRandomByRandTomM(7,5)+" ");
        System.out.println();


    }


    /**
     * 从给定能生成1-m的随机数的基础上,设计生成随机数是1-n的范围
     *
     * @param m
     * @param n
     * @return
     */
    public static int getRandomByRandTomM(int m, int n) {
        int res = 0;
        if (m < n) {
            int s =((m * m ) - (m * m) % n)-1;
            do {
                res = (randTomM(m) - 1) * m + randTomM(m) - 1;
            } while (res > s);
        } else {

            do {
                res = randTomM(m);
            } while (res > n);
        }
        return res % n + 1;
    }

    public static int randTomM(int m) {
        return (int) (Math.random() * m + 1);
    }
}
