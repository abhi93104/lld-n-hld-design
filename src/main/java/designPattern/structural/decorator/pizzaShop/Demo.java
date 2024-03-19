package designPattern.structural.decorator.pizzaShop;

import designPattern.structural.decorator.pizzaShop.decorator.*;

import java.util.Scanner;

public class Demo {

    public static void main(String... args) {

        BasePizza bp = new CheesePizza();
        Scanner sc = new Scanner(System.in);
        boolean preparePizza = false;
        while(!preparePizza) {
            System.out.print("Add topping\n1. Tomato\n2. Onion\n3. Jalapeno\n4. Mushroom\n5. Extra Cheese\n6. Prepare Pizza\n");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> bp = new TomatoToppingDecorator(bp);
                case 2 -> bp = new OnionToppingDecorator(bp);
                case 3 -> bp = new JalapenoToppingDecorator(bp);
                case 4 -> bp = new MushroomToppingDecorator(bp);
                case 5 -> bp = new ExtraCheeseDecorator(bp);
                case 6 -> preparePizza = true;
                default -> System.out.println("Invalid option. Choose from above options");
            }
        }
        System.out.printf("Pizza Prepared with toppings: %s\n", bp.getTopping());
        System.out.printf("Cost of Pizza: %d\n", bp.getCost());
    }



}
