package ch03.ex02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Hodaka
 */
public class SynchronizedOperation {

    public static void withLock(ReentrantLock lock, Runnable operation) {
        lock.lock();
        try {
            operation.run();
        } finally {
            lock.unlock();
        }
    }
}
