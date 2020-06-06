package com.example.springdemo.chenyi.doanthying;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author: chenyi
 * @date: 2019-11-21:10:13
 * @desciption:
 */
@Data
@Slf4j
public class ThreadLocalDo {

    /**
     * ThreadLocal是一个线程安全的类
     * 主要的原因在于ThreadLocal底层实现为ThreadLocalMap 用来保证每个线程有自己独立的操作副本，避免线程竞争
     */

    public static final ThreadLocal threadLocal = new ThreadLocal();

    public final  ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 50, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r);
        }
    }, new ThreadPoolExecutor.AbortPolicy());
    public static void main(String[] args) {


//
//        threadPoolExecutor.execute(()-> System.out.println("哈哈哈"));

        //将一个long的数字转换成  ,分割的字符串

        long  abc  =152368799998L;


        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
//
        System.out.println(format.format(abc));
//
//        System.out.println(abc+"");


        String abcstr = abc+"";

       abcagtad(abc);

       String abgc = "1111111111";
        System.out.println(Long.MAX_VALUE);
       String agtc ="9223372036854775807";
        add(abgc,agtc);



    }


    public static  String abcagtad(long abc){
        if (abc<10){
            return "0.0"+abc;
        }
        if (abc<100){
            return "0."+abc;
        }
        String ad = String.valueOf(abc);
        int index  =2;

        while (index<=ad.length()){
            String  head= ad.substring(0,ad.length()-index);
            String  tail= ad.substring(ad.length()-index);
            if (index == 2){
                ad = head+"."+tail;
            }else {
                ad = head + "," + tail;
            }
            index = index +4;

        }
        System.out.println(""+ad+"元");
        return "";
    }

    public static String add(String num1,String num2){

        try {
            Long num1Int = new Long(num1);
            Long num2Int = new Long(num2);

            long num =  num1Int +num2Int ;
            if (num<0){
                System.out.println(num);
            }
            return num+"";
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        return "";
    }


    @Test
    public void  test(){
        CountDownLatch countDownLatch  = new CountDownLatch(1);

        HashMap<String, String> hashMap = new HashMap<>();

        Runnable runnable =  ()-> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"开始执行"+" == " +System.currentTimeMillis());
            String s = hashMap.putIfAbsent("abc", "abc");
            System.out.println(Thread.currentThread().getName()+ "执行结果"+ s);
        };
        Runnable runnable1 =  ()-> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( Thread.currentThread().getName()+"开始执行"+" == " +System.currentTimeMillis());
            String s = hashMap.putIfAbsent("abc", "abc");
            System.out.println(Thread.currentThread().getName()+ "执行结果"+ s);

        };
        Runnable runnable2 =  ()-> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( Thread.currentThread().getName()+"开始执行"+" == " +System.currentTimeMillis());
            String s = hashMap.putIfAbsent("abc", "abc");
            System.out.println(Thread.currentThread().getName()+ "执行结果"+ s);
        };
        Runnable runnable3 =  ()-> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"开始执行"+" == " +System.currentTimeMillis());
            String s = hashMap.putIfAbsent("abc", "abc");
            System.out.println(Thread.currentThread().getName()+ "执行结果"+ s);

        };
        threadPoolExecutor.execute(runnable);
        threadPoolExecutor.execute(runnable1);
        threadPoolExecutor.execute(runnable2);
        threadPoolExecutor.execute(runnable3);

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countDownLatch.countDown();


    }

    @Test
    public void testa(){

    }


}
