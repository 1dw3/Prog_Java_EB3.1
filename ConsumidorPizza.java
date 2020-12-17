package evaluacion3;

import java.util.Random;

public class ConsumidorPizza implements Runnable {
    private Pizza pizza;
 
    public ConsumidorPizza(Pizza pizza) {
        this.pizza = pizza;
    }
 
    public void run() {
        Random random = new Random();
        for (String tipoPizza = pizza.repartirPizza(); ! pizza.equals("fin"); tipoPizza = pizza.repartirPizza()) {
            System.out.format("Pizza: %s%n", tipoPizza);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
    }
}

