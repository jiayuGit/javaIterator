package com.interrator;

public class Code44 {
    public static void main(String[] ags) {
        for(int i =0;i<10;i++)
            System.out.print(getRandomByRandTomM(7,5)+" ");
        System.out.println();

//        System.out.println(gcd(102,41));
//        System.out.println(getZeroNum(1000000000));
//        int a = 24;
//        a = ((a^(a-1))+1)>>1;
//        System.out.println(a);
//        System.out.println(getArrAnd("123456","112356"));
    }
//    public static int getArrAnd(String s1,String s2){
//        char[] cs1 = s1.toCharArray();
//        char[] cs2 = s2.toCharArray();
//        int[][] dp = new int[cs2.length][cs1.length];
//        int max = Integer.MIN_VALUE;
//        for (int i = 0;i<cs1.length;i++){
//            if(cs1[i]==cs2[0]){
//                dp[0][i]=1;
//            }
//        }
//        for (int i = 0;i<cs2.length;i++){
//            if(cs1[0]==cs2[i]){
//                dp[i][0]=1;
//            }
//        }
//        for(int i = 1;i<cs2.length;i++){
//            for(int j = 1;j<cs1.length;j++){
//                if(cs1[j]==cs2[i]){
//                    dp[i][j]=dp[i-1][j-1]+1;
//                    max = Math.max(max,dp[i][j]);
//                }
//            }
//        }
//        return max;
//    }
//    public static int getZeroNum(int n){
//        int res = 0;
//        while(n!=0){
//            n/=5;
//            res+=n;
//        }
//        return res;
//    }
//    public static int gcd(int m,int n){
//        return n==0?m:gcd(n,m%n);
//    }
//

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
