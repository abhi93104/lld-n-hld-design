package Concurrency.ConcurrencyProblemNSolutionExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {

    Lock l = new ReentrantLock();

    public static void main(String... args){
        System.out.println("Deadlock example. In this both threads are trying to get both lock but each one is " +
                "only get one lock and will stuck in a deadlock situation\n");
        new Thread(()->{
            System.out.printf("Trying to get String class lock by %s\n", Thread.currentThread().getName());
            synchronized (String.class){
                System.out.printf("String class acquired by %s\n", Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.printf("Trying to get Object class lock by %s\n", Thread.currentThread().getName());
                synchronized (Object.class){
                    System.out.printf("String Object both lock acquired by %s\n", Thread.currentThread().getName());
                }
            }
        }, "thread1").start();

        new Thread(()->{
            System.out.printf("Trying to get Object class lock by %s\n", Thread.currentThread().getName());
            synchronized (Object.class){
                System.out.printf("Object class acquired by %s\n", Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.printf("Trying to get String class lock by %s\n", Thread.currentThread().getName());
                synchronized (String.class){
                    System.out.printf("Object String both lock acquired by %s\n", Thread.currentThread().getName());
                }
            }
        }, "thread2").start();
    }
}
