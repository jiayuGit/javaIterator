package com.interrator;

public class Code61 {
    public static void main(String[] ags) {
        System.out.println(getCandy(new int[]{2,1,2,3,4,2,3}));
    }

    /**
     * 分糖果问题 分数高的孩子至少比相邻分数少的多,每个孩纸最少一个
     * 时间复杂度O(N)
     * 空间复杂度1
     * @param arr
     * @return
     */
    public static int getCandy(int[] arr) {
        int index = getIndexArr(arr, 0);
        int res = rightCands(0, index++);
        int lbase = 1;
        while (index < arr.length) {
            if (arr[index] > arr[index - 1]) {
                res += ++lbase;
                index++;
            } else if (arr[index] < arr[index - 1]) {
                int next = getIndexArr(arr, index-1);//计算下坡的长度
                int rcands= rightCands(index-1, next++);//计算下坡的前N项和
                int rbase = next - index + 1;
                res+= rcands+(rbase>lbase?-lbase:-rbase);//取上坡和下坡中高的一边为点 因为两个坡都用了最高的哪个的值,减去没有被采用点的高度值
                lbase=1;
                index=next;
            }else {
                res +=1;
                lbase = 1;
                index++;
            }
        }
        return res;
    }

    /**
     * 等差数组前N项和
     * @param i
     * @param index
     * @return
     */
    private static int rightCands(int i, int index) {
        int n = index - i + 1;
        return n + n * (n - 1) / 2;
    }

    /**
     * 获取下坡数组的下标
     * @param arr
     * @param i
     * @return
     */
    private static int getIndexArr(int[] arr, int i) {
        while (i < arr.length - 1) {
            if (arr[i] <= arr[i + 1]) {
                return i;
            }
            i++;
        }
        return arr.length - 1;
    }
}
