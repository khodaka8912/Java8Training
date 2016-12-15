package ch03.ex19;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * @author hodaka
 */
public class Streams<T> {

    List<T> stream;

    /**
     * U を ? super Uに書き換えることは可能だが、引数をU以外で受け取ってUを返すaccumulatorは通常利用しない。
     */
    <U> U reduce(U identity, BiFunction<? super U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        U result = identity;
        for (T element : stream) {
            result = accumulator.apply(result, element);
        }
        return result;
    }
}
