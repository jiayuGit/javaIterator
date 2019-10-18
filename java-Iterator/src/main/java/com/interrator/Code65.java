package com.interrator;

import java.util.HashMap;
import java.util.Map;

public class Code65 {
    public static void main(String[] ags) {
        int[] a = new int[]{1, 3};
        int[] b = new int[]{1, 3};
        System.out.println();
        MessageBox messageBox = new MessageBox();
        messageBox.receive(2);
        messageBox.receive(1);
        messageBox.receive(4);
        messageBox.receive(5);
        messageBox.receive(7);
        messageBox.receive(3);
        messageBox.receive(9);
        messageBox.receive(8);
        messageBox.receive(6);
    }


}
/**
 * 构成连续的打印流
 */
class MessageBox {
    Map<Integer, NodeN> headMap = null;
    Map<Integer, NodeN> endMap = null;
    int lastPrint;

    public MessageBox() {
        headMap = new HashMap();
        endMap = new HashMap();
        lastPrint = 0;
    }

    public void receive(int num) {
        NodeN node = new NodeN(num);
        headMap.put(num, node);
        endMap.put(num, node);
        if (endMap.containsKey(num - 1)) {
            endMap.get(num - 1).next = node;
            endMap.remove(num - 1);
            headMap.remove(num);
        }
        if (headMap.containsKey(num + 1)) {
            node.next = headMap.get(num + 1);
            headMap.remove(num + 1);
            endMap.remove(num);
        }
        if (headMap.containsKey(lastPrint + 1)) {
            prinNum();
        }
    }

    private void prinNum() {
        NodeN node = headMap.remove(lastPrint + 1);
        NodeN cur = node;
        while (node != null) {
            System.out.print(node.value + " ");
            lastPrint++;
            cur = node;
            node = node.next;
        }
        System.out.println();
        endMap.remove(cur.value);
    }

}
class NodeN {
    int value;
    NodeN next;

    public NodeN() {
    }

    public NodeN(int value) {
        this.value = value;
    }
}

