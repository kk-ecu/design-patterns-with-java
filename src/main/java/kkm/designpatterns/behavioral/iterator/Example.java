/*
Iterator Pattern
Intent: Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

Real-Life Example: Iterating over a collection of books in a library, one by one.
 */
package kkm.designpatterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

// Iterator interface
interface Iterator {
    boolean hasNext();
    Object next();
}

// Aggregate interface
interface BookCollection {
    Iterator createIterator();
}

// Concrete Iterator
class BookIterator implements Iterator {
    private List<String> books;
    private int position = 0;

    public BookIterator(List<String> books) {
        this.books = books;
    }

    public boolean hasNext() {
        return position < books.size();
    }

    public String next() {
        return books.get(position++);
    }
}

// Concrete Aggregate
class Library implements BookCollection {
    private List<String> books = new ArrayList<>();

    public void addBook(String book) {
        books.add(book);
    }

    public Iterator createIterator() {
        return new BookIterator(books);
    }
}

public class Example {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("Design Patterns");
        library.addBook("Effective Java");

        Iterator iterator = library.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // Output:
        // Design Patterns
        // Effective Java
    }
}

