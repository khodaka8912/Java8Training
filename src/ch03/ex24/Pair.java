package ch03.ex24;

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

    /**
     * 値を2つしか格納できないため、{@code Pair<Pair<U>>}をフラット化できない。
     *
     * @param mapper
     * @param <U>
     * @return
     */
    <U> Pair<U> flatMap(Function<T, Pair<U>> mapper) {
        throw new UnsupportedOperationException();
    }
}
