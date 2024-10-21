/*
Factory Pattern
Intent: Provides an interface for creating objects in a super class, but allows subclasses to alter the type of objects that will be created.

Real-Life Example: A factory that makes different types of cars (SUV, Sedan, etc.).
 */

package kkm.designpatterns.creational.factory;

abstract class Car {
    abstract void drive();
}

class SUV extends Car {
    void drive() {
        System.out.println("Driving an SUV!");
    }
}

class Sedan extends Car {
    void drive() {
        System.out.println("Driving a Sedan!");
    }
}

class CarFactory {
    public Car createCar(String type) {
        if (type.equals("SUV")) {
            return new SUV();
        } else if (type.equals("Sedan")) {
            return new Sedan();
        }
        return null;
    }
}

public class Example {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();
        Car myCar = factory.createCar("SUV");
        myCar.drive(); // Driving an SUV!
    }
}
