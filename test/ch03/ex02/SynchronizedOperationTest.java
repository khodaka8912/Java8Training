package ch03.ex02;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.*;

/**
 * @author hodaka
 */
public class SynchronizedOperationTest {
    @Test
    public void testWithLock() throws InterruptedException {
        Object lock = new Object();
        Runnable wait = () -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread = new Thread(() -> SynchronizedOperation.withLock(reentrantLock, wait));

        thread.start();
        Thread.sleep(300);
        assertEquals(Thread.State.WAITING, thread.getState());
        assertTrue(reentrantLock.isLocked());

        synchronized (lock) {
            lock.notifyAll();
        }
        thread.join();

        assertFalse(reentrantLock.isLocked());
    }

}