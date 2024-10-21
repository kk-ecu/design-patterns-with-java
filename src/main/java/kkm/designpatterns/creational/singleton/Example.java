/*
Singleton Pattern
Intent: Ensures a class has only one instance and provides a global point of access to it.

Real-Life Example: A President of a country—there’s only one at any time.
 */

package kkm.designpatterns.creational.singleton;

class President {
    private static President instance;

    private President() {
        // Private constructor to prevent instantiation
    }

    public static President getInstance() {
        if (instance == null) {
            instance = new President();
        }
        return instance;
    }

    public void govern() {
        System.out.println("Governing the country!");
    }
}

public class Example {
    public static void main(String[] args) {
        President president = President.getInstance();
        president.govern(); // Governing the country!
    }
}

