package designPattern.structural.decorator.pizzaShop.decorator;

import designPattern.structural.decorator.pizzaShop.BasePizza;
import lombok.Data;

@Data
public abstract class BasePizzaDecorator extends BasePizza {
    private BasePizza wrappee;

}
