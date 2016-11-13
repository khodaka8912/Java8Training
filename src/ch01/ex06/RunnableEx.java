package ch01.ex06;

/**
 * @author hodaka
 */
public interface RunnableEx {

    void run() throws Exception;

    static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
