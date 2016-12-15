package ch03.ex18;

import java.util.function.Function;

/**
 * @author hodaka
 */
public class Functions {

    @FunctionalInterface
    interface CheckedFunction<T, R> {
        R apply(T t) throws Exception;
    }

    static <T, R> Function<T, R> unchecked(CheckedFunction<T, R> checked) {
        return t -> {
            try {
                return checked.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
