package ch09.ex08;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author hodaka
 */
public class PointTest {
    @Test
    public void testCompareTo() throws Exception {
        Point[] points = {Point.of(0, 0), Point.of(2, 3), Point.of(0, 1), Point.of(4, 1)};

        assertTrue(points[0].compareTo(points[0]) == 0);
        assertTrue(points[0].compareTo(points[1]) < 0);
        assertTrue(points[1].compareTo(points[2]) > 0);
        assertTrue(points[1].compareTo(points[3]) < 0);
        assertTrue(points[1].compareTo(points[0]) > 0);
    }

}