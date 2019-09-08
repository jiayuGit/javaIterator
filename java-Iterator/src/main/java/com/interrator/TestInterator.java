package com.interrator;

import sun.misc.Unsafe;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;

public class TestInterator {

    public static void main(String[] agrs){
        /*Collection conlletion = null;
        List<Integer> list=new LinkedList();
        Set<Integer> set=null;
        Queue queue=null;
        Iterator iterator=null;
        list = new ArrayList();
        for (int i=0;i<15;i++)
        {
            list.add(i);
        }
        list.add(null);
        list.forEach(new Consumer<Integer>() {
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        set =new LinkedHashSet();
        //set = new HashSet();

        //set = new LinkedHashSet();
        System.out.println("----------------");
        for (int i=0;i<13;i++)
        {
            set.add(2+i*16);
        }
        set.add(32);
        set.add(51);
        set.remove(34);
        iterator = set.iterator();
        iterator.forEachRemaining(new Consumer<Integer>() {
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        Map map=new TreeMap();
        //map=new LinkedHashMap();
        map.put("aa","aa");
        map.put("bb","aa");
        map.put("cc","aa");
        map.remove("aa");
        //SynchronousQueue<String> synchronousQueue =
        list = Collections.synchronizedList(new LinkedList<>());
        list.add(15);
        list.add(16);
        list.add(null);

        list.remove(new Integer(16));
        set = Collections.synchronizedSet(new LinkedHashSet<>());
        set.add(15);
        set.add(null);
        set.remove(1);
        map = Collections.synchronizedSortedMap(new TreeMap());
        map.put("aa","aa");
        map.put("bb","bb");
        map.put("cc",null);

        map = Collections.synchronizedMap(new LinkedHashMap<>());
        map.put("aa","aa");
        map.put("bb","bb");
        map.put(null,null);
        map.remove("aa");
        Vector v;
        map =new Hashtable();
        map.put("aa","aa");
        map.put("cc","cc");
        map.put("dd","dd");
        map.put("bb","bb");
        map.remove("aa");
        map.put("aa","a");

        //Unsafe u=Unsafe.getUnsafe();
        concurrentMap = new ConcurrentHashMap();
        concurrentMap.put("a","a");
        concurrentMap.put("b","a");
        concurrentMap.put("c","a");

        concurrentMap.get("a");
        concurrentMap.remove("a");
       //for (int i =0;i<100;i++) {
        //   Integer h =- new Integer((int) (Math.random() * ((1 << 31) - 1)));
        //   System.out.print(h+"---->");
       //    System.out.println((h ^ (h >>> 16)) & 0x7fffffff);
      // }
       // System.out.println(0x7fffffff+"->"+((1 << 31) - 1));
       // ReentrantLock reentrantLock = new ReentrantLock(true);*/
       // ConcurrentMap concurrentMap =new ConcurrentHashMap();
      //  concurrentMap.put("a","a");
      //  BlockingQueue<Object> blockingQueue = null;
      //  blockingQueue =new SynchronousQueue();
     //   blockingQueue = new ArrayBlockingQueue(10);
        //try {
            //blockingQueue.offer("a") ;
           // blockingQueue.offer("b") ;
           // blockingQueue.offer("c") ;

        //try {
          //  blockingQueue.poll();//1000,TimeUnit.MINUTES);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
       // }
       // int i=blockingQueue.remainingCapacity();
      //      System.out.println(i);
        //}
       // Lock lock = new ReentrantLock(false);
      //  lock.lock();
      //  try {
      //      lock.lockInterruptibly();
      //      System.out.println(lock.tryLock(1,TimeUnit.MINUTES));
      //  } catch (InterruptedException e) {
      //      e.printStackTrace();
      //  }
      //  lock.unlock();
       // ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

       // LinkedHashMap m =new LinkedHashMap();
      //  m.put("a","a");
      //  m.put("b","a");
       // m.put("c","a");
      //  m.remove("a");
        String s = new String("http://sysadmin:123456@10.15.15.89:8090/ demo/testWar.git");
        String[] strings = s.split("//");
        String[] strings2 = strings[1].split("@");
        for (int j=0;j<strings2.length;j++){
            System.out.println(strings2[j]);
        }

        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("a","a");
        Hashtable hs =new  Hashtable();
        hs.put("a","a");
        for (int i =0 ;i<100;i++){
            int num =(int) (Math.random()*((float)Integer.MAX_VALUE));
            num = Math.random()<0.5? -num:num;
            System.out.print(num+"->");
            System.out.println(((num ^ num >>> 16)) & 0x7fffffff);
        }
        System.out.println("azsfdsaasfggakj".hashCode());
        System.out.println();
        System.out.println(map.getClass().getClassLoader());
        ExecutorService executorService  = Executors.newCachedThreadPool();
        ThreadPoolExecutor t;
        //ThreadLocalMap a;
    }
}
