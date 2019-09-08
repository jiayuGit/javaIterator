package com.interrator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Heap {
    NodeHeap[] nodes;
    int size;

    public Heap(int k) {
        nodes = new NodeHeap[k];
        size = 0;
    }

    public void insert(NodeHeap node) {
        if (size == nodes.length) {
            return;
        }
        nodes[size++] = node;
        heapifyInsert(size - 1);
    }

    public NodeHeap poll() {
        NodeHeap res = nodes[0];
        swap(nodes, 0, --size);
        heapifyPoll();
        return res;
    }

    private void heapifyPoll() {
        int i = 0;
        int m = 0 * 2 + 1;
        NodeHeap res = nodes[0];
        while (m < size) {
            if (m + 1 < size && nodes[m + 1].times < res.times && nodes[m + 1].times < nodes[m].times) {
                nodes[i] = nodes[m++];
                i = m;
                m = m * 2 + 1;
            } else if (nodes[m].times < res.times) {
                nodes[i] = nodes[m];
                i = m;
                m = 2 * m + 1;
            }
        }
        nodes[i] = res;
    }

    private void swap(NodeHeap[] nodes, int i, int j) {
        NodeHeap a = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = a;
    }
    public void heapifyPollAndInsert(NodeHeap nodeHeap){
        nodes[0] = nodeHeap;
        heapifyPoll();
    }
    private void heapifyInsert(int k) {
        NodeHeap res = nodes[k];

        while (k != 0) {
            if (nodes[(k - 1) / 2].times > res.times) {
                nodes[k] = nodes[(k - 1) / 2];
                k = (k - 1) / 2;
            } else {
                break;
            }
        }
        nodes[k] = res;
    }
    public NodeHeap getTop(){
        return nodes[0];
    }
}

class NodeHeap {
    String value;
    int times;

    public NodeHeap(String value, int times) {
        this.value = value;
        this.times = times;
    }

    @Override
    public String toString() {
        return "NodeHeap{" +
                "value='" + value + '\'' +
                ", times=" + times +
                '}';
    }
}

/**
 * 重复字符的前K个
 */
class TopPrinK{
    public static void main(String[] ags){
        String[] arr =new String[]{"1","2","3","4","3"};
        prinTopKAndRank(arr,2);
    }
    public static void prinTopKAndRank(String[] srs,int k){
        Map<String,Integer> map = new HashMap<>();
        for (String s:srs) {
            if(!map.containsKey(s)){
                map.put(s,1);
            }else {
                map.put(s,map.get(s)+1);
            }
        }
        Heap heap = new Heap(k);
        for (Map.Entry<String,Integer> s:map.entrySet()
             ) {
            if(heap.size==k){
                if(heap.getTop().times<s.getValue()){
                    heap.heapifyPollAndInsert(new NodeHeap(s.getKey(),s.getValue()));
                }
            }else {
                heap.insert(new NodeHeap(s.getKey(),s.getValue()));
            }
        }
        while (heap.size>0
             ) {
            System.out.println(heap.poll());
        }
    }
}
