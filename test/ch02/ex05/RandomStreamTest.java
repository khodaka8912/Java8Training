package ch02.ex05;

import org.junit.Test;

import java.util.stream.LongStream;

/**
 * @author hodaka
 */
public class RandomStreamTest {

    @Test
    public void testCreate() {
        long a = 25214903917L;
        long c = 11L;
        long m = (long) Math.pow(2, 48);
        LongStream stream = RandomStream.create(0, a, c, m);
        stream.limit(100).forEach(l -> System.out.printf("%d, ", l));
    }

}