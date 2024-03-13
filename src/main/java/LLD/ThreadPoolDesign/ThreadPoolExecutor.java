package LLD.ThreadPoolDesign;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class ThreadPoolExecutor {

    private final LinkedBlockingQueue<Runnable> blkQueue;
    private Boolean isThreadPoolClosed;
    private LinkedList<Thread> thList;

    public ThreadPoolExecutor(){
        blkQueue = new LinkedBlockingQueue<>();
        isThreadPoolClosed = FALSE;
        thList = new LinkedList<>();

    }


    class RunnableThreads implements Runnable{

        Runnable task;

        @Override
        public void run(){

            while (!blkQueue.isEmpty() || !isThreadPoolClosed) {
                synchronized (blkQueue) {
                        task = blkQueue.poll();
                }
                try {
                    if (task != null) {
                        task.run();
                    }
                }catch (RuntimeException re){
                    System.out.println("Thread interrupted");
                }


            }
        }

    }

    public List<Thread> newFixedThreadPool(int size){
        for(int i=0;i<size;i++){
            RunnableThreads r = new RunnableThreads();
            Thread th = new Thread(r);
            th.start();
            thList.add(th);
        }
        return thList;
    }

    public void execute(Runnable r){
        synchronized (blkQueue) {
            try {
                blkQueue.put(r);
                blkQueue.notify();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void closeThreadPool(){
        isThreadPoolClosed = TRUE;
    }

}


