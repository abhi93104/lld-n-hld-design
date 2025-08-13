package Concurrency.ConcurrencyProblemNSolutionExample;


import java.util.Date;

public class RaceConditionSolution implements Runnable{

    private int ticketAvailable;

    public RaceConditionSolution(){
        this.ticketAvailable = 1;

    }
    void checkAndAct(){
        synchronized (this) {
            if (this.ticketAvailable > 0) {
                System.out.printf("%s - ticket assigning for %s\n", new Date(), Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                this.ticketAvailable--;
                System.out.printf("%s - ticket assigned to %s\n", new Date(), Thread.currentThread().getName());
            } else {
                System.out.printf("%s No ticket available for %s\n", new Date(), Thread.currentThread().getName());
            }
        }

    }

    @Override
    public void run(){
        checkAndAct();
    }

    public static void main(String... args) {
        RaceConditionSolution r = new RaceConditionSolution();
        Thread t1 = new Thread(r, "passenger1");
        Thread t2 = new Thread(r, "passenger2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("%d \n", r.ticketAvailable);
    }
}
