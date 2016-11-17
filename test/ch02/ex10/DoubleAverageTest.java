package ch02.ex10;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author hodaka
 */
public class DoubleAverageTest {

    @Test
    public void testAverage() {
        Stream<Double> stream = Stream.of(1.0, 3.0, -2.0, 5.0);
        double expected = (1.0 + 3.0 - 2.0 + 5.0) / 4;

        double ave = DoubleAverage.average(stream);

        assertEquals(expected, ave, 0.00001);
    }

    @Test
    public void testAverageEmpty() {
        Stream<Double> stream = Stream.empty();

        double ave = DoubleAverage.average(stream);

        assertTrue(Double.isNaN(ave));
    }

}