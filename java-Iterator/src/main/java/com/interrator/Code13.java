package com.interrator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Code13 {

    public static void main(String[] ags){
        MyMap myMap = new MyMap();
        for (int i = 0;i<5;i++){
            myMap.put(i,i);
        }
        myMap.setAll(10);
        for (int i = 5;i<10;i++){
            myMap.put(i,i+100);
        }
        for (int i = 0;i<10;i++){
            System.out.print(myMap.get(i)+" ");
        }
        System.out.println();

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


    static class MyValue<T>{
        T value;
        long time;
        public MyValue(T value,long time){
            this.value=value;
            this.time=time;
        }
    }

    /**
     * 设计一个Map,可以有setAll方法
     * 时间复杂度O(1)
     * @param <K>
     * @param <V>
     */
    static class MyMap<K,V>{
        Map<K,MyValue<V>> map = null;
        MyValue<V> setAll = null;
        long time = 0;
        public MyMap(){
            map = new HashMap<>();
        }
        public void setAll(V value){
            setAll = new MyValue<>(value,time++);
        }
        public void put(K key,V value){
            map.put(key,new MyValue<>(value,time++));
        }
        public V get(K key){
            if (setAll!=null&&map.get(key).time<=setAll.time){
                return setAll.value;
            }
            return map.get(key).value;

        }

    }
}
