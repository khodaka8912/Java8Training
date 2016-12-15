package ch02.ex05;

import java.util.stream.LongStream;

/**
 * @author hodaka
 */
public class RandomStream {

    public static LongStream create(long seed, long a, long c, long m) {
        Math.multiplyExact(a, c);
        return LongStream.iterate(seed, x -> (a * x + c) % m);
    }
}
