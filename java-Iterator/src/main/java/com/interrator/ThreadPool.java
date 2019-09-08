package com.interrator;

import java.util.Hashtable;
import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[]    agr){
        ExecutorService executorService = new
                ThreadPoolExecutor(2,3,1000,
                TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<Runnable>(2) ,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
                );
        for(int i = 0;i<5;i++){
           executorService.execute(new ThreadRunnable());
        }
        //executorService.submit();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        //scheduledExecutorService.scheduleAtFixedRate();
        Hashtable h = new Hashtable();



    }
}
class ThreadRunnable implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
