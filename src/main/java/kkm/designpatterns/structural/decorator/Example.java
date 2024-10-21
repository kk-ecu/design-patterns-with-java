/*
Decorator Pattern
Intent: Attach additional responsibilities to an object dynamically.

Real-Life Example: Adding decorations (e.g., icing, sprinkles) to a cake.
 */
package kkm.designpatterns.structural.decorator;

interface Cake {
    String decorate();
}

class BasicCake implements Cake {
    public String decorate() {
        return "Basic Cake";
    }
}

class CakeDecorator implements Cake {
    protected Cake cake;

    CakeDecorator(Cake cake) {
        this.cake = cake;
    }

    public String decorate() {
        return cake.decorate();
    }
}

class SprinklesDecorator extends CakeDecorator {
    SprinklesDecorator(Cake cake) {
        super(cake);
    }

    public String decorate() {
        return super.decorate() + " with Sprinkles";
    }
}

public class Example {
    public static void main(String[] args) {
        Cake cake = new SprinklesDecorator(new BasicCake());
        System.out.println(cake.decorate()); // Basic Cake with Sprinkles
    }
}

