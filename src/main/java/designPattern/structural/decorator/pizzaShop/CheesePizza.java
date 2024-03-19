package designPattern.structural.decorator.pizzaShop;

public class CheesePizza extends BasePizza{


    public CheesePizza(){
        super();
    }

    @Override
    public String getTopping() {
        return "Base Pizza with Cheese added";
    }

    @Override
    public int getCost() {
        return 100;
    }
}
