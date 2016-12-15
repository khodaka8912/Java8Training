package ch03.ex22;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

/**
 * @author hodaka
 */
public class CompletableFutures {

    static <T, U> CompletableFuture<U> flatMap(CompletableFuture<T> future, Function<T, CompletableFuture<U>> mapper) {
        return new CompletableFuture<U>() {

        };
    }
}
