package designPattern.behaviour.strategy.services;

import designPattern.behaviour.strategy.interfaces.IPaymentStrategy;

public class PaymentService {

    private IPaymentStrategy paymentStrategy;

    public PaymentService(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public Boolean performTransaction(int amount){
        return this.paymentStrategy.transact(amount);
    }
}
