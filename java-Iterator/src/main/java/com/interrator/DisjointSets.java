package com.interrator;

import java.util.HashMap;
import java.util.Map;

public class DisjointSets<T extends Node> {
    Map<T,T> fathMap ;
    Map<T,Integer> rankMap ;//最长串

    public DisjointSets() {
        fathMap = new HashMap<>();
        rankMap = new HashMap<>();
    }
    //初始化
    public void makeSets(T node){
        fathMap.clear();
        rankMap.clear();
        preOderMake(node);
    }

    private void preOderMake(T node) {
        if(node==null){
            return;
        }
        preOderMake((T)node.left);
        fathMap.put(node,node);
        rankMap.put(node,0);
        preOderMake((T)node.right);
    }

    //获取主节点
    public T findFather(T node){
        if(node==null){
            return null;
        }
        T cur = node;
        if(fathMap.get(node)!=node){
            cur = findFather(node);
        }
        fathMap.put(node,cur);
        return cur;
    }
    public void union(T node1,T node2){
        if(node1==null||node2==null){
            return;
        }
        T a = findFather(node1);
        T b = findFather(node2);
        if(a!=b) {
            int i = rankMap.get(a);
            int j = rankMap.get(b);
            if (i < j) {
                fathMap.put(a, b);
            }else if(i>j){
                fathMap.put(b,a);
            }else {
                fathMap.put(b,a);
                rankMap.put(a,rankMap.get(a)+1);
            }
        }
    }

}
class Node<V>{
    V value;
    Node left;
    Node right;
}
