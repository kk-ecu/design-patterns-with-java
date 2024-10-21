/*
Adapter Pattern
Intent: Converts the interface of a class into another interface clients expect.

Real-Life Example: A power adapter allows a two-pin plug to fit into a three-pin socket.
 */
package kkm.designpatterns.structural.adapter;

interface Target {
    void request();
}

class Adaptee {
    public void specificRequest() {
        System.out.println("Specific request!");
    }
}

class Adapter implements Target {
    private Adaptee adaptee;

    Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.specificRequest();
    }
}

public class Example {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.request(); // Specific request!
    }
}

