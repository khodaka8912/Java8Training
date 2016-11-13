package ch01.ex07;

/**
 * @author hodaka
 */
public class ContinuousRunner {

    private ContinuousRunner() {
    }

    /**
     * Create runnable that runs first and then second.
     *
     * @param first  Runnable to be run first.
     * @param second Runnable to be run second.
     * @return Runnable that runs first and then second.
     */
    public static Runnable andThen(Runnable first, Runnable second) {
        return () -> {
            first.run();
            second.run();
        };
    }
}
