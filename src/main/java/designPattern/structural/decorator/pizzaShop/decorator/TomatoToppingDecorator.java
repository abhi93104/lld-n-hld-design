package designPattern.structural.decorator.pizzaShop.decorator;

import designPattern.structural.decorator.pizzaShop.BasePizza;

public class TomatoToppingDecorator extends BasePizzaDecorator{


    public TomatoToppingDecorator(BasePizza basePizza){
        this.setWrappee(basePizza);
    }

    /**
     * Do recursive call and get toppings. E.g. first CheesePizza called then Tomato so first it will get child toppings i.e CheesePizza and then its Tomato.
     * @return return toppings
     */
    @Override
    public String getTopping() {
        return getWrappee().getTopping() + " Tomato added";
    }

    @Override
    public int getCost() {
        return getWrappee().getCost() + 30;
    }
}
