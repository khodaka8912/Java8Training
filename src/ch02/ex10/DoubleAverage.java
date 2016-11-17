package ch02.ex10;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author hodaka
 */
public class DoubleAverage {

    static double average(Stream<Double> stream) {
        AtomicInteger count = new AtomicInteger(0);
        double sum = stream.reduce(0.0, (d1, d2) -> {
            count.incrementAndGet();
            return d1 + d2;
        });
        if (count.get() == 0) {
            return Double.NaN;
        }
        return sum / count.get();
    }
}
