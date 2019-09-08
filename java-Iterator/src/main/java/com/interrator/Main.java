package com.interrator;

import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hashtable hashtable = new Hashtable();
        hashtable.put("a","a");
        String s = sc.next();
        String[] ss = s.split(",");
        Node2 node = getTree(ss[0], ss[1]);
        prin(node);
    }
    public static void prin(Node2 no){
        if (no==null){
            return;
        }
        prin(no.left);
        prin(no.right);
        System.out.print(no.value);
    }

    private static Node2 getTree(String s1, String s2) {
        int[] arr = new int[]{0};
        Node2 head = getTr(s1.toCharArray(), arr, s2.toCharArray(), 0, s2.length());
        return head;
    }

    private static Node2 getTr(char[] chars1, int[] i1, char[] chars2, int i2, int j2) {
        if(i2>j2||i1[0]>=chars1.length){
            return null;
        }
        Node2 node = new Node2();
        node.value = chars1[i1[0]];
        int index = getChar2(chars1[i1[0]], chars2, i2, j2);
        i1[0]++;
        node.left = getTr(chars1, i1, chars2, i2, index - 1);
        node.right = getTr(chars1, i1, chars2, index + 1, j2);
        return node;
    }

    private static int getChar2(char c, char[] chars2, int i2, int j2) {
        for (int i = i2; i <= j2; i++) {
            if (c == chars2[i]) {
                return i;
            }
        }
        return -1;
    }
}

class Node2 {
    char value;
    Node2 left;
    Node2 right;
}
