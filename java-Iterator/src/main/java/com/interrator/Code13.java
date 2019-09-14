package com.interrator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Code13 {

    public static void main(String[] ags){
        Pool pool = new Pool();
        for (int i = 0;i<5;i++){
            pool.insert(i);
        }
        for (int i = 0;i<3;i++){
            System.out.println(pool.getRandom());
        }
    }

    /**
     * 在容器中装入值,可以随机取出
     * @param <K>
     */
    static class Pool<K>{
        Map<K,Integer> indexMap = null;
        Map<Integer,K> keyMap = null;
        int size = 0;
        Pool(){
            indexMap = new HashMap<>();
            keyMap = new HashMap<>();
        }
        public void insert(K key){
            if(!indexMap.containsKey(key)){
                indexMap.put(key,size);
                keyMap.put(size,key);
                size++;
            }
        }
        public K delete(K key){
            if(indexMap.containsKey(key)){
                int index = indexMap.get(key);
                indexMap.remove(key);
                indexMap.put(keyMap.get(size-1),index);
                keyMap.put(index,keyMap.remove(--size));
                return key;
            }
            return null;
        }
        public K getRandom(){
            int m = (int)(Math.random()*size);
            return delete(keyMap.get(m));
        }
    }





}
