package ch01.ex06;

import org.junit.Test;

/**
 * @author hodaka
 */
public class RunnableExTest {
    @Test
    public void testUncheck() throws InterruptedException {
        Thread thread = new Thread(RunnableEx.uncheck(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);
        }));

        thread.start();

        thread.join();
    }

}