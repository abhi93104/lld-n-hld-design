package designPattern.structural.decorator.pizzaShop;

import lombok.Data;

@Data
public abstract class BasePizza {
    private Integer cost;
    private String topping;

    /**
     *
     * @return toppings added to Pizza
     */
    public abstract String getTopping();

    /**
     *
     * @return returns cost pizza
     */
    public abstract int getCost();

}
