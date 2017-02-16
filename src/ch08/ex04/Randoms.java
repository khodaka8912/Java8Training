package ch08.ex04;

import java.util.Random;
import java.util.stream.LongStream;

/**
 * @author hodaka
 */
public class Randoms {

    static final long V = 246154705703781L;
    static final long A = 11L;
    static final long N = 1L << 48;
    static final long M = 25214903917L;

    static final int SEARCH_COUNT = 1000000;

    static long prev(long s) {
        return (s - A) * V % N;
    }

    static void searchMinSeed() {
        long minSeed = LongStream.iterate(prev(0), s -> prev(prev(s)))
                .map(s -> s ^ M)
                .limit(SEARCH_COUNT)
                .reduce((s1, s2) -> Math.min(Math.abs(s1), Math.abs(s2)))
                .getAsLong();

        System.out.println("Min seed is : " + minSeed);
        Random generator = new Random(minSeed);
        for (int i = 1; i < SEARCH_COUNT; i++) {
            if (generator.nextDouble() == 0.0) {
                System.out.println("Random(minSeed) get 0.0 after " + i + " times nextDouble");
                break;
            }
        }
    }

    public static void main(String[] args) {
        searchMinSeed();
    }
}
