package com.interrator;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.concurrent.CyclicBarrier;
public class cD2 implements Runnable{
    private   CyclicBarrier end;
    private  int s;
    public cD2(CyclicBarrier end,int i){
        this.end=end;
        s=i;
    }
    @Override
    public  void run(){  //线程同步用了synchronized否则无法保证s的正确性
        try{
            System.out.println(s+"队准备完毕");
            s=s-1;
            end.await();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {

        CyclicBarrier end = new CyclicBarrier(11);  //await为10+1=11个
        for(int j=0;j<10;j++){
            new Thread(new cD2(end,j)).start();   //开启10个线程
        }
        end.await(); 		  //阻塞程序，直到10个子线程全部运行的await处
        System.out.println("\n10队全部准备结束。。。后面的程序开始运行");
        Set s  = new HashSet();

        Hashtable h  = new Hashtable();
        h.put("a","a");
        //do others
    }
}

