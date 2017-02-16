package ch08.ex08;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hodaka
 */
public class CheckedQueueSample {

    static void addPathString(Queue queue) {
        queue.add("This is a path.");
    }

    static void addPath(Queue queue) {
        queue.add(Paths.get("."));
    }

    static void doSomething(Queue<Path> queue) {
        Path path = queue.remove();
        System.out.println("Done something.");
    }

    public static void main(String[] args) {
        Queue<Path> pathQueue = new LinkedList<>();

        System.out.println("When work with normal Queue:");
        try {
            addPathString(pathQueue);
            System.out.println("OK, I added a path.");
        } catch (ClassCastException e) {
            System.out.println("Oh, I added a wrong type... (" + e.getMessage() + ")");
            addPath(pathQueue);
        }
        try {
            doSomething(pathQueue);
        } catch (ClassCastException e) {
            System.out.println("Someone added wrong class to Queue!! (" + e.getMessage() + ")");
        }

        pathQueue = new LinkedList<>();
        System.out.println("When work with checked Queue:");
        try {
            addPathString(Collections.checkedQueue(pathQueue, Path.class));
            System.out.println("OK, I added a path.");
        } catch (ClassCastException e) {
            System.out.println("Oh, I added a wrong type... (" + e.getMessage() + ")");
            addPath(pathQueue);
        }
        try {
            doSomething(pathQueue);
        } catch (ClassCastException e) {
            System.out.println("Someone added wrong class to Queue!! (" + e.getMessage() + ")");
        }

    }
}
