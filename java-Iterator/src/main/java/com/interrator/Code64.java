package com.interrator;

public class Code64 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3};//前序
        int[] b = new int[]{1, 3};//中序
        Node head = getTree(a, b, new int[]{0}, 0, b.length - 1);
        System.out.println(getMaxH(head, new int[]{0}));
    }
    /**
     * 先序数组和中序数组构建二叉树
     *
     * @param a
     * @param b
     * @param n  先序当前的下标
     * @param bi
     * @param bj
     * @return
     */
    public static Node getTree(int[] a, int[] b, int[] n, int bi, int bj) {
        if (bi > bj) {
            return null;
        }
        Node head = new Node();
        head.value = a[n[0]];
        int index = getArrIndex(b, bi, bj, a[n[0]]);
        n[0]++;
        head.left = getTree(a, b, n, bi, index - 1);
        head.right = getTree(a, b, n, index + 1, bj);
        return head;
    }

    /**
     * 获取数据段中的对应数值的下标
     *
     * @param b
     * @param bi
     * @param bj
     * @param i
     * @return
     */
    private static int getArrIndex(int[] b, int bi, int bj, int i) {
        for (int j = bi; j <= bj; j++) {
            if (b[j] == i) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 获得树的两个节点最大距离
     *
     * @param head
     * @param res
     * @return
     */
    public static int getMaxH(Node head, int[] res) {
        if (head == null) {
            res[0] = 0;
            return 0;
        }
        int maxLeft = getMaxH(head.left, res);
        int maxLeftH = res[0];
        int maxRight = getMaxH(head.right, res);
        int maxRightH = res[0];
        res[0] = Math.max(maxLeftH, maxRightH) + 1;
        return Math.max(Math.max(maxLeft, maxRight), maxLeftH + maxRightH + 1);
    }
}
