package com.interrator;

import java.util.concurrent.Semaphore;

public class cD3 implements Runnable{
    private   Semaphore sema;
    private  int s;
    public cD3(Semaphore sema,int i){
        this.sema=sema;
        s=i;
    }
    @Override
    public void run(){  //线程同步用了synchronized否则无法保证s的正确性
        try{
            sema.acquire();  //获取一个控制信号
            System.out.println(s+"队准备完毕");
            s--;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            sema.release(); //释放信号
        }
    }
    public static void main(String[] args) throws Exception {
        Semaphore sema = new Semaphore(2);
        for(int j=0;j<4;j++){
            new Thread(new cD3(sema,j)).start();   //开启5个线程，5个线程分别获得一个信号量，然后释放
        }
    }
}

