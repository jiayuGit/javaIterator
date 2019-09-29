package com.interrator;

public class Code52 {
    public static void main(String[] args) {
        Tree head = new Tree();
        for (int i = 0;i<5;i++){
            head.setNode((int)(Math.random()*5));
        }
        Node node = head.getIsNode(2);
        System.out.println(node.value);
    }

    /**
     * 二叉排序树
     */
    static class Tree {
        private Node head = null;
        public Tree() {

        }
        public void setNode(int a){
            setTree(head,a);
        }
        public Node getIsNode(int a){
            return getIsInTree(head,a);
        }

        /**
         * 存在a着返回,没有着增加
         * @param head
         * @param a
         * @return
         */
        private Node getIsInTree(Node head, int a) {
            if(head==null){
                return new Node(a);
            }
            Node node = null;
            if(head.value>a){
                 node= getIsInTree(head.left,a);
                 if(head.left==null){
                     head.left=node;
                 }
            }else if(head.value<a){
                node = getIsInTree(head.right,a);
                if(head.right==null){
                    head.right=node;
                }
            }else {
                node = head;
            }
            return node;
        }

        /**
         * 生成排序树
         * @param head
         * @param a
         * @return
         */
        private Node setTree(Node head, int a) {
            if(head==null){
                return new Node(a);
            }

            if(head.value>a){
                head.left = setTree(head.left,a);
            }else if(head.value<a){
                head.right = setTree(head.right,a);
            }
            return head;
        }
    }
    static class Node{
        int value;
        Node left;
        Node right;
        public Node(){

        }
        public Node(int value) {
            this.value = value;
        }
    }
}
