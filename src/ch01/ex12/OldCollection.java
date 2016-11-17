package ch01.ex12;

import java.util.Collection;

/**
 * @author hodaka
 */
public abstract class OldCollection<E> implements Collection<E> {

    public void stream() {
        System.out.println("cannot compile");
    }
}
