package com.interrator;

import java.sql.Connection;
import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JUCTest implements Runnable{
    static ReentrantReadWriteLock rr = new ReentrantReadWriteLock();
    private  Exchanger<String> exchange ;
    private  String name;
    private	 String str;
    public JUCTest(Exchanger<String> exchange,String name,String str){
        this.exchange=exchange;
        this.name=name;
        this.str=str;
    }
    @Override
    public void run(){  //线程同步用了synchronized否则无法保证s的正确性
        try{
            //rr.readLock().lock();
            System.out.println(name+"线程自己的数据时："+str);
            String s=exchange.exchange(str);    //交换数据
            System.out.println(name+"获取另一个线程的数据："+s);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        Exchanger<String> ex=new Exchanger<String>();
        new Thread(new JUCTest(ex,"zhou","Hello")).start();
        new Thread(new JUCTest(ex,"yu","World")).start();
        Collection c;

        FutureTask<Integer> task=new FutureTask<Integer>(new Callable<Integer>(){public Integer call(){ return 1+2+3+4;}}); //匿名内部类
        new Thread(task).start();
        System.out.println("做自己的事，计算1+2+3+4交给另一个线程完成\n");
        int i = task.get();
        System.out.println("返回获取结果 "+task.get());
        TreeMap a;
        ConcurrentSkipListMap b;
        ConcurrentLinkedQueue q;
        LinkedBlockingQueue l;
        LockSupport ls;
        ClassLoader cc;
        //rr.readLock().lock();
        rr.writeLock().lock();
        Set s;

    }

}

