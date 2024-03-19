package designPattern.structural.decorator.pizzaShop.decorator;

import designPattern.structural.decorator.pizzaShop.BasePizza;

public class MushroomToppingDecorator extends BasePizzaDecorator{


    public MushroomToppingDecorator(BasePizza basePizza){
        this.setWrappee(basePizza);
    }

    /**
     * Do recursive call and get toppings. E.g. first CheesePizza called then Mushroom so first it will get child toppings i.e CheesePizza and then its Mushroom.
     * @return return toppings
     */
    @Override
    public String getTopping() {
        return getWrappee().getTopping() + " Mushroom added";
    }

    @Override
    public int getCost() {
        return getWrappee().getCost() + 45;
    }
}
