package LLD.ThreadPoolDesign;

import java.util.Date;
import java.util.List;

public class ThreadpoolUsage implements Runnable{

    @Override
    public void run(){
        Date date = new Date();
        System.out.println(date +  " Thread running. Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(date +  " Thread finish. Thread: " + Thread.currentThread().getName());
    }


    public static void main(String args[]){
        ThreadPoolExecutor thpe = new ThreadPoolExecutor();
        List<Thread> thList = thpe.newFixedThreadPool(10);
        for(int i=0 ; i<100 ; i++){
            Runnable r = new ThreadpoolUsage();
            thpe.execute(r);
        }
        thpe.closeThreadPool();
    }
}
