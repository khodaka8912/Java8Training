package ch06.ex03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author hodaka
 */
public class Counters {

    static final int THREAD_NUM = 1000;
    static final int COUNT_NUM = 100000;

    static void count(int num, AtomicLong counter) {
        for (int i = 0; i < num; i++) {
            counter.incrementAndGet();
        }
    }

    static void count(int num, LongAdder counter) {
        for (int i = 0; i < num; i++) {
            counter.increment();
        }
    }

    static long measureTime(Runnable task) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);
        long start = System.nanoTime();
        for (int i = 0; i < THREAD_NUM; i++) {
            executor.execute(task);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        AtomicLong atomicCounter = new AtomicLong();
        long timeElapsed = measureTime(() -> count(COUNT_NUM, atomicCounter));
        System.out.printf("Atomic counter elapsed\t %,15d [ns] while counting %,d.%n", timeElapsed,
                atomicCounter.get());
        LongAdder adderCounter = new LongAdder();
        timeElapsed = measureTime(() -> count(COUNT_NUM, adderCounter));
        System.out.printf("Adder counter elapsed\t %,15d [ns] while counting %,d.%n", timeElapsed,
                adderCounter.sum());
    }
}
