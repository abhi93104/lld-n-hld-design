package designPattern.structural.decorator.pizzaShop.decorator;

import designPattern.structural.decorator.pizzaShop.BasePizza;

public class ExtraCheeseDecorator extends BasePizzaDecorator{


    public ExtraCheeseDecorator(BasePizza basePizza){
        this.setWrappee(basePizza);
    }

    /**
     * Do recursive call and get toppings. E.g. first CheesePizza called then Extra Cheese so first it will get child toppings i.e CheesePizza and then its ExtraCheese.
     * @return return toppings
     */
    @Override
    public String getTopping() {
        return getWrappee().getTopping() + " ExtraCheese added";


    }

    @Override
    public int getCost() {
        return this.getWrappee().getCost() + 50;
    }
}
