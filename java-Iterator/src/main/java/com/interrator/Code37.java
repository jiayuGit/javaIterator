package com.interrator;

import java.util.HashMap;
import java.util.Map;

public class Code37 {
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
    static class MyValue<T>{
        T value;
        long time;
        public MyValue(T value,long time){
            this.value=value;
            this.time=time;
        }
    }
}
