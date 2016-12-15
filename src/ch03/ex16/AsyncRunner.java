package ch03.ex16;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author hodaka
 */
public class AsyncRunner {

    static <T> void doInOrerAsync(Supplier<T> first, BiConsumer<T, Throwable> second, Consumer<Throwable> handler) {
        new Thread() {
            @Override
            public void run() {
                T t = null;
                Throwable throwable = null;
                try {
                    t = first.get();
                } catch (Throwable th) {
                    throwable = th;
                }
                try {
                    second.accept(t, throwable);
                } catch (Throwable th) {
                    handler.accept(th);
                }
            }
        }.start();
    }
}
