package ch06.ex11;

import java.io.Console;
import java.net.PasswordAuthentication;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author hodaka
 */
public class Repeater {

    public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
        return CompletableFuture.supplyAsync(action)
                .thenComposeAsync(t -> until.test(t) ? CompletableFuture.completedFuture(t) : repeat(action, until));
    }

    public static void main(String[] args) {
        Console console = System.console();
        repeat(() -> {
            System.out.print("user :");
            String user = console.readLine();
            System.out.print("password :");
            char[] pass = console.readPassword();
            return new PasswordAuthentication(user, pass);
        }, pa -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Arrays.equals(pa.getPassword(), new char[]{'s', 'e', 'c', 'r', 'e', 't'});
        }).thenAccept(System.out::println);

        ForkJoinPool.commonPool().awaitQuiescence(100, TimeUnit.SECONDS);
    }
}
