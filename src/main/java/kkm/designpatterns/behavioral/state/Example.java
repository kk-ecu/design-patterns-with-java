/*
State Pattern
Intent: Allows an object to alter its behavior when its internal state changes.

Real-Life Example: A traffic light that changes behavior based on its current state (Green, Yellow, Red).
 */
package kkm.designpatterns.behavioral.state;

// State interface
interface TrafficLightState {
    void handle();
}

// Concrete states
class GreenLight implements TrafficLightState {
    public void handle() {
        System.out.println("Green light: Cars can go!");
    }
}

class RedLight implements TrafficLightState {
    public void handle() {
        System.out.println("Red light: Cars must stop!");
    }
}

class YellowLight implements TrafficLightState {
    public void handle() {
        System.out.println("Yellow light: Cars should slow down.");
    }
}

// Context class
class TrafficLight {
    private TrafficLightState state;

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void change() {
        state.handle();
    }
}

public class Example {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        trafficLight.setState(new GreenLight());
        trafficLight.change(); // Green light: Cars can go!

        trafficLight.setState(new YellowLight());
        trafficLight.change(); // Yellow light: Cars should slow down.

        trafficLight.setState(new RedLight());
        trafficLight.change(); // Red light: Cars must stop!
    }
}

