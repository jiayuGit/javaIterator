package com.interrator;

import java.util.concurrent.CountDownLatch;
public class cD implements Runnable{
    private   CountDownLatch begin ;
    private   CountDownLatch end;
    private int s;
    public cD(CountDownLatch begin,CountDownLatch end){
        this.begin=begin;
        this.end=end;
        this.s=10;
    }
    @Override
    public void run(){  //线程同步用了synchronized否则无法保证s的正确性
        try{                       //注意：await用在synchronized可能导致死锁，如果换成CyclicBarrier类会导致死锁
            begin.await();    //等待begin统一
            System.out.println(s+" 次"+Thread.currentThread());
            System.out.println();
            s--;
            //do something
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            end.countDown();
        }
    }
    public static void main(String[] args) throws Exception {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(10);
        cD juc=new cD(begin,end);
        for(int j=0;j<10;j++){
            new Thread(juc).start();   //开启10个线程，10个线程分别倒数1次，并让end减一次
        }
        //开始倒数计时，开启begin的countDown()方法
        System.out.println("开始倒数计数!。。。10次");
        begin.countDown();  //begin减到0，则开始10个线程里面的await()方法后面的程序
        end.await(); 		  //阻塞程序，知道end减为0
        System.out.println("倒数结束。。。后面的程序开始运行");
        //do others

    }
}
