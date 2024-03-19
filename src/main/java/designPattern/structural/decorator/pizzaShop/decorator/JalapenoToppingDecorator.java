package designPattern.structural.decorator.pizzaShop.decorator;

import designPattern.structural.decorator.pizzaShop.BasePizza;

public class JalapenoToppingDecorator extends BasePizzaDecorator{



    /**
     * Do recursive call and get toppings. E.g. first CheesePizza called then Jalapeno so first it will get child toppings i.e CheesePizza and then its Jalapeno.
     * @return return toppings
     */
    public JalapenoToppingDecorator(BasePizza basePizza){
        this.setWrappee(basePizza);
        getTopping();
    }

    @Override
    public String getTopping() {
        return getWrappee().getTopping() + " Jalapeno added";
    }

    @Override
    public int getCost() {
        return getWrappee().getCost() + 40;
    }
}
