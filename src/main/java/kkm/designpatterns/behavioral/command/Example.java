/*
Command Pattern
Intent: Encapsulate a request as an object, allowing you to parameterize clients with queues, requests, and operations.

Real-Life Example: Using a remote control to issue commands like turning on/off the TV.
 */
package kkm.designpatterns.behavioral.command;

// Command interface
interface Command {
    void execute();
}

// Concrete commands
class TurnOnCommand implements Command {
    private TV tv;

    public TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOn();
    }
}

class TurnOffCommand implements Command {
    private TV tv;

    public TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOff();
    }
}

// Receiver class
class TV {
    public void turnOn() {
        System.out.println("TV is ON.");
    }

    public void turnOff() {
        System.out.println("TV is OFF.");
    }
}

// Invoker class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class Example {
    public static void main(String[] args) {
        TV tv = new TV();
        Command turnOn = new TurnOnCommand(tv);
        Command turnOff = new TurnOffCommand(tv);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(turnOn);
        remote.pressButton(); // TV is ON.

        remote.setCommand(turnOff);
        remote.pressButton(); // TV is OFF.
    }
}

