package com.interrator;

public class Code25 {
    public static void main(String[] ags) {
        printOddDeble(new int[]{5, 6, 1, 3, 4, 5, 4, 3});
    }

    /**
     * 找出数组中两个唯一不相同的数
     * 时间复杂度为O(N)
     * @param arr
     */
    public static void printOddDeble(int[] arr) {
        int res = 0;
        for (int a : arr//第一次得到两个唯一不数的~后的结果
        ) {
            res ^= a;
        }
        int o = res & (~res + 1);//得出二进制中为1的最低位,这个位置说明两个值的这个位置值相反(~的计算方式是不相同为1,相同为0)
        int dp = 0;
        for (int a : arr
        ) {
            if ((o & a) == 0) {//过滤掉一些数据,而且过滤的时候一定是过滤一对一对的数据,
                                // 其中有一个是答案中的一个,因为&o的值有一个是1,另一个是0,这样剩下来的就能得到一个答案
                dp ^= a;
            }
        }
        System.out.println(dp + " " + (dp ^ res));
    }
}
