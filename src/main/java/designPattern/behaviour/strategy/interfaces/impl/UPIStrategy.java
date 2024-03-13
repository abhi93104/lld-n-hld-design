package designPattern.behaviour.strategy.interfaces.impl;

import designPattern.behaviour.strategy.interfaces.IPaymentStrategy;

public class UPIStrategy implements IPaymentStrategy {
    @Override
    public Boolean transact(int amount) {
        System.out.println("Doing transaction by UPI for amount: " + amount);
        return true;
    }
}
