/*
Composite Pattern
Intent: Compose objects into tree-like structures to represent part-whole hierarchies.

Real-Life Example: A file system where directories contain files and subdirectories, allowing operations to be performed on either individual files or directories as a whole.
 */
package kkm.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

// Component
abstract class FileSystemComponent {
    String name;
    public FileSystemComponent(String name) {
        this.name = name;
    }
    public abstract void display();
}

// Leaf class
class File extends FileSystemComponent {
    public File(String name) {
        super(name);
    }

    public void display() {
        System.out.println("File: " + name);
    }
}

// Composite class
class Directory extends FileSystemComponent {
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void display() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.display();
        }
    }
}

public class Example {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory subDir = new Directory("subdir");

        root.addComponent(new File("file1.txt"));
        subDir.addComponent(new File("file2.txt"));

        root.addComponent(subDir);
        root.display();
        // Output:
        // Directory: root
        // File: file1.txt
        // Directory: subdir
        // File: file2.txt
    }
}

