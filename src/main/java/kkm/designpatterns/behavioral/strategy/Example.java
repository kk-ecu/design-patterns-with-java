/*
Strategy Pattern
Intent: Define a family of algorithms, encapsulate each one, and make them interchangeable.

Real-Life Example: Choosing different payment methods for shopping (Credit Card, PayPal, etc.).
 */
package kkm.designpatterns.behavioral.strategy;

// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete strategy classes
class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

// Context class
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Set the strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class Example {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100); // Paid 100 using Credit Card.

        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(200); // Paid 200 using PayPal.
    }
}

