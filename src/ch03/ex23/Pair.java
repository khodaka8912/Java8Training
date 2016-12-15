package ch03.ex23;

import java.util.function.Function;

/**
 * @author hodaka
 */
public class Pair<T> {

    final T first;
    final T second;

    Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    <U> Pair<U> map(Function<T, U> mapper) {
        return new Pair<U>(mapper.apply(first), mapper.apply(second));
    }

}
