package Concurrency.ThreadRunnableNCallable;

import java.util.ArrayList;
import java.util.Date;

public class RunnableThreadV2 implements Runnable{

    int a=0;
    @Override
    public void run() {
        System.out.println(new Date() + " Starting new Thread - " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        a+=1;
        System.out.println(new Date() + " a = " + a +  " Finishing Thread - " + Thread.currentThread().getName());
    }

    public static void main(String args[]){
        int numOfThread = 10;
        ArrayList<Thread> thList = new ArrayList<>();
        Runnable r = new RunnableThreadV2(); // Single runnable share same object
        for(int i = 0; i < numOfThread; i++){
//            Runnable r = new Concurrency.ThreadRunnableNCallable.RunnableThreadV2(); // Each thread with each runnable will not share same object
            thList.add(new Thread(r));
        }

        for(int i = 0; i < numOfThread; i++){
            thList.get(i).start();
        }

    }

}
