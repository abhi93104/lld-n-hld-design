package designPattern.behaviour.strategy.interfaces.impl;

import designPattern.behaviour.strategy.interfaces.IPaymentStrategy;

public class NEFTStrategy implements IPaymentStrategy {
    @Override
    public Boolean transact(int amount) {
        System.out.println("Doing transaction by NEFT for amount: " + amount);
        return true;
    }
}
