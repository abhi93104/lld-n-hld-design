package Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class MultiThreadingCombined {

    static class ThreadExtend extends Thread{

        private int data;

        public ThreadExtend(int data){
            this.data = data;
        }

        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName() + " Running Thread in ThreadExtends. Accessing data: "+ data);
            data += 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " Running Thread in ThreadExtends. Saving data: "+ data);
        }
    }

    static class ThreadRunnable implements Runnable{

        public void run(){
            System.out.println("Running Thread in ThreadRunnable");
        }
    }

    static class CallableThread implements Callable<String>{

        @Override
        public String call(){
            System.out.println("Running Thread in CallableThread: " + Thread.currentThread().getName());
            return Thread.currentThread().getName();
        }


    }

    public static void main(String args[]){
         ExecutorService theEx = Executors.newFixedThreadPool(2);
         for(int i = 0 ; i < 10 ; i++){
            theEx.execute(new ThreadExtend(new Random().nextInt(10)));
        }

         theEx.shutdown();



        Runnable runn = new ThreadRunnable();
        Thread thRunn = new Thread(runn);
        thRunn.start();

        ExecutorService service = Executors.newFixedThreadPool(10);
        CallableThread thCall = new CallableThread();
        List<Future<String>> ftList = new ArrayList<>();
        for(int i=0;i<10;i++){
            ftList.add(service.submit(thCall));
        }
        service.shutdown();
        for(int i=0;i<10;i++){
            try {
                System.out.println(ftList.get(i).get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }


    }



}
