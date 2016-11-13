package ch01.ex06;

import java.util.concurrent.Callable;

/**
 * @author hodaka
 */
public class Main {
    public static void main(String[] args) {
        new Thread(RunnableEx.uncheck(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);
        })).start();
    }

    /**
     * Callableを使用すると、返り値のないRunnable同等の処理を渡すことができない。
     */
    @Deprecated
    private static Runnable uncheck(Callable<Void> caller) {
        return () -> {
            try {
                caller.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
