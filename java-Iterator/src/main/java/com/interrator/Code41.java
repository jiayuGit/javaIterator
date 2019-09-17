package com.interrator;

import java.util.LinkedList;
import java.util.Queue;

public class Code41 {
    public static void main(String[] ags) {
        int[][] arr = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(minPathValue(arr));
        System.out.println(arr);
        for (int[] a:arr
        ) {
            for (int b:a
            ) {
                System.out.print(b+" ");
            }
            System.out.println();
        }
    }

    /**
     * 矩阵中到达对角的最短路径
     * 时间复杂度O(N*M)
     *
     * @param arr
     * @return
     */
    public static int minPathValue(int[][] arr) {
        int[][] map = new int[arr.length][arr[0].length];
        Queue<Integer> xb = new LinkedList<Integer>();
        Queue<Integer> yb = new LinkedList<Integer>();
        map[0][0] = 1;
        xb.add(0);
        yb.add(0);
        while (!xb.isEmpty() && !yb.isEmpty()) {//按照折线遍历,每次遍历都是当前折线长度能到达的最远距离
            int x = xb.poll();
            int y = yb.poll();
            if (x == arr.length - 1 && y == arr[0].length - 1) {
                return map[x][y];
            }
            walkTo(map[x][y], x - 1, y, arr, map, xb, yb);
            walkTo(map[x][y], x + 1, y, arr, map, xb, yb);
            walkTo(map[x][y], x, y - 1, arr, map, xb, yb);
            walkTo(map[x][y], x, y + 1, arr, map, xb, yb);
        }
        return -1;
    }

    private static void walkTo(int res, int x, int y, int[][] arr, int[][] map, Queue<Integer> xb, Queue<Integer> yb) {
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || arr[x][y] == 0 || map[x][y] != 0) {
            return;
        }
        map[x][y] = res + 1;//到达该位置的距离是上一个位置的值+1
        xb.add(x);
        yb.add(y);
    }
}
