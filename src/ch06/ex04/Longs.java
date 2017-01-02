package ch06.ex04;

import java.util.Arrays;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * @author hodaka
 */
public class Longs {

    static long max(long[] elements) {
        LongAccumulator accumulator = new LongAccumulator(Long::max, Long.MIN_VALUE);
        Arrays.stream(elements).parallel().forEach(accumulator::accumulate);
        return accumulator.get();
    }

    static long min(long[] elements) {
        LongAccumulator accumulator = new LongAccumulator(Long::min, Long.MAX_VALUE);
        Arrays.stream(elements).parallel().forEach(accumulator::accumulate);
        return accumulator.get();
    }

    public static void main(String[] args) {
        long[] elements = {0, 1, -10, 100, -1000, 10000, -100000};
        System.out.println("Max value : " + max(elements));
        System.out.println("Min value : " + min(elements));
    }
}
