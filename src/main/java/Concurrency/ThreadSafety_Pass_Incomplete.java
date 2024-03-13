package Concurrency;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
//import java.util.concurrent.


public class ThreadSafety_Pass_Incomplete implements Runnable {

    List<Integer> globalList = new CopyOnWriteArrayList<>();

    public static void main(String... args) {
        ThreadSafety_Fail target = new ThreadSafety_Fail();
        new Thread(target).start();
        new Thread(target).start();
        new Thread(target).start();
        new Thread(target).start();
    }

    public int addSum(Integer a, Integer b){
        Integer c;
        c = a + b;
        return c;
    }

    @Override
    public void run() {
        int field = new SecureRandom().nextInt();
        if(globalList.size()<1){
            globalList.add(0, field);
        }
        globalList.set(0, field);
        Integer local = new SecureRandom().nextInt();
        List<Integer> localList = new ArrayList<>();
        if(localList.size()<1){
            localList.add(0, field);
        }

        localList.set(0, local);
        Integer c = addSum(new SecureRandom().nextInt(100), new SecureRandom().nextInt(100));
        System.out.println(globalList.get(0) + ":" + localList.get(0) + " : " + c);
    }
}