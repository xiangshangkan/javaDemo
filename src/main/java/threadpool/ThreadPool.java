package threadpool;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description: Java五种线程池方法
 * @Author: zhouhui2
 * @Date: 2022/4/27 11:13 AM
 */
public class ThreadPool {
    public static void main(String args[]) {

        ExecutorService ex1 = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            int some = i;
            ex1.submit(()-> System.out.println(some));
        }
        ex1.shutdown();


        // 创建只有一个线程的线程池
         ExecutorService ex2 = Executors.newSingleThreadExecutor();

        // 创建一个不限线程数上限的线程池，任何提交的任务都将立即执行
         ExecutorService ex3 = Executors.newCachedThreadPool();

         // 创建一个按照计划规定执行的线程池
        ExecutorService ex4 = Executors.newScheduledThreadPool(2);

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2  = sc.next();

    }
}
