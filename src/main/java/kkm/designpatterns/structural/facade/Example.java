/*
Facade Pattern
Intent: Provide a unified interface to a set of interfaces in a subsystem.

Real-Life Example: A restaurant facade that provides simplified methods to order food, without exposing complex details about kitchen operations.
 */
package kkm.designpatterns.structural.facade;

// Complex subsystems
class OrderSystem {
    public void takeOrder(String item) {
        System.out.println("Order placed for: " + item);
    }
}

class KitchenSystem {
    public void prepareOrder(String item) {
        System.out.println("Preparing " + item);
    }
}

class PaymentSystem {
    public void processPayment(double amount) {
        System.out.println("Processing payment of: $" + amount);
    }
}

// Facade class
class RestaurantFacade {
    private OrderSystem orderSystem = new OrderSystem();
    private KitchenSystem kitchenSystem = new KitchenSystem();
    private PaymentSystem paymentSystem = new PaymentSystem();

    public void orderFood(String item, double amount) {
        orderSystem.takeOrder(item);
        kitchenSystem.prepareOrder(item);
        paymentSystem.processPayment(amount);
    }
}

public class Example {
    public static void main(String[] args) {
        RestaurantFacade restaurant = new RestaurantFacade();
        restaurant.orderFood("Pizza", 12.99);
        // Output:
        // Order placed for: Pizza
        // Preparing Pizza
        // Processing payment of: $12.99
    }
}

