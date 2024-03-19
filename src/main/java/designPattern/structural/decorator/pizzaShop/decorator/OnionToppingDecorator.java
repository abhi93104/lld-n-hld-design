package designPattern.structural.decorator.pizzaShop.decorator;

import designPattern.structural.decorator.pizzaShop.BasePizza;

public class OnionToppingDecorator extends BasePizzaDecorator{


    public OnionToppingDecorator(BasePizza basePizza){
        this.setWrappee(basePizza);
    }

    /**
     * Do recursive call and get toppings. E.g. first CheesePizza called then Onion so first it will get child toppings i.e CheesePizza and then its Onion.
     * @return return toppings
     */
    @Override
    public String getTopping() {
        return getWrappee().getTopping() + " Onion added";

    }

    @Override
    public int getCost() {
        return getWrappee().getCost() + 30;
    }
}
