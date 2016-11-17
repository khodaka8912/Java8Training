package ch02.ex09;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author hodaka
 */
public class ArrayLists {

    static <E> ArrayList<E> toArrayList(Stream<ArrayList<E>> stream) {
        return stream.reduce(new ArrayList<E>(), (a1, a2) -> {
            a1.addAll(a2);
            return a1;
        }, (a1, a2) -> {
            a1.addAll(a2);
            return a1;
        });
    }
}
