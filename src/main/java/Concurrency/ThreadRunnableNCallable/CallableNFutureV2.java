package Concurrency.ThreadRunnableNCallable;

import java.util.*;
import java.util.concurrent.*;

public class CallableNFutureV2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception{
        // Individual tasks
        Date d = new Date();
        Random r = new Random();
        int rand = r.nextInt(12);
        int month  = Calendar.getInstance().get(Calendar.MONTH);
        System.out.println(Thread.currentThread().getName() + ": " + d + " Calendar Month: " + month + " random no." + rand);
        return month + rand;
    }

    public static void main(String args[]){
        int numOfThreads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
        CallableNFutureV2 callableNFutureV2 = new CallableNFutureV2();
        List<Future<Integer>> fList = new ArrayList<>();
        for(int i = 0; i <  numOfThreads; i++){
            fList.add(executorService.submit(callableNFutureV2));
        }

        for(int i = 0; i <  numOfThreads; i++){
            try {
                System.out.println(fList.get(i).get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
