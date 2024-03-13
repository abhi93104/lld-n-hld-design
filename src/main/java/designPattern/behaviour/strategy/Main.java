package designPattern.behaviour.strategy;


import designPattern.behaviour.strategy.interfaces.impl.MandateStrategy;
import designPattern.behaviour.strategy.interfaces.impl.NEFTStrategy;
import designPattern.behaviour.strategy.interfaces.impl.UPIStrategy;
import designPattern.behaviour.strategy.services.PaymentService;

public class Main {

    public static void main(String[] args){
        PaymentService service1 = new PaymentService(new MandateStrategy());
        service1.performTransaction(100);
        PaymentService service2 = new PaymentService(new NEFTStrategy());
        service2.performTransaction(250);
        PaymentService service3 = new PaymentService(new UPIStrategy());
        service3.performTransaction(500);
    }
}
