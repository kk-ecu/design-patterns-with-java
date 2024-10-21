/*
Observer Pattern
Intent: Define a one-to-many dependency where if one object changes state, all its dependents are notified.

Real-Life Example: A YouTube channel where subscribers are notified of new videos.
 */
package kkm.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Subscriber implements Observer {
    private String name;

    Subscriber(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

class Channel {
    private List<Observer> observers = new ArrayList<>();
    private String message;

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifySubscribers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void uploadVideo(String title) {
        this.message = "New video uploaded: " + title;
        notifySubscribers();
    }
}

public class Example {
    public static void main(String[] args) {
        Channel channel = new Channel();
        Observer user1 = new Subscriber("User1");
        Observer user2 = new Subscriber("User2");

        channel.subscribe(user1);
        channel.subscribe(user2);

        channel.uploadVideo("Design Patterns in Java"); // Both subscribers get notified
    }
}

