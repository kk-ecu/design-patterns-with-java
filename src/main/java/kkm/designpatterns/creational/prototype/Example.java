/*
Prototype Pattern
Intent: Create a clone of an object, instead of creating new instances from scratch.

Real-Life Example: Copying a file on your computer instead of creating a new one.
 */

package kkm.designpatterns.creational.prototype;

class Document implements Cloneable {
    String content;

    Document(String content) {
        this.content = content;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return content;
    }
}

public class Example {
    public static void main(String[] args) throws CloneNotSupportedException {
        Document original = new Document("Original Document");
        Document copy = (Document) original.clone();
        System.out.println(copy); // Original Document
    }
}

