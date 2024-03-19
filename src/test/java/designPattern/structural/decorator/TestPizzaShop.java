package designPattern.structural.decorator;


import designPattern.structural.decorator.pizzaShop.BasePizza;
import designPattern.structural.decorator.pizzaShop.CheesePizza;
import designPattern.structural.decorator.pizzaShop.decorator.JalapenoToppingDecorator;
import designPattern.structural.decorator.pizzaShop.decorator.MushroomToppingDecorator;
import designPattern.structural.decorator.pizzaShop.decorator.OnionToppingDecorator;
import designPattern.structural.decorator.pizzaShop.decorator.TomatoToppingDecorator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestPizzaShop {

    @BeforeEach
    public void setup(){
        System.out.println("Setup runs before each teat");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("TearDown runs after completion of each test to clear everything.");
    }

    @Test
    public void Test1(){
        BasePizza bp = new OnionToppingDecorator(new TomatoToppingDecorator(new CheesePizza()));
        Assertions.assertEquals(bp.getCost() , 160);
    }

    @Test
    public void Test2(){
        BasePizza bp = new JalapenoToppingDecorator(new OnionToppingDecorator(new MushroomToppingDecorator(new CheesePizza())));
        Assertions.assertEquals(bp.getCost() , 215);
    }

    @Test
    public void Test3(){
        BasePizza bp = new CheesePizza();
        Assertions.assertEquals(bp.getCost(), 100);
    }
}
