package ch01.ex09;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author hodaka
 */
public interface Collection2<E> extends Collection<E> {

    /**
     * Perform an action for each element of this collection after filtered.
     *
     * @param action Action to be performed.
     * @param filter Filter that chooses elements to use.
     */
    default void forEachIf(Consumer<E> action, Predicate<E> filter) {
        stream().filter(filter).forEach(action);
    }
}
