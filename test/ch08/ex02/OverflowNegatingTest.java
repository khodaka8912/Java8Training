package ch08.ex02;

import org.junit.Test;

/**
 * @author hodaka
 */
public class OverflowNegatingTest {

    @Test(expected = ArithmeticException.class)
    public void testOverflowNegateExactInt() {
        Math.negateExact(Integer.MIN_VALUE);
    }

    @Test(expected = ArithmeticException.class)
    public void testOverflowNegateExactLong() {
        Math.negateExact(Long.MIN_VALUE);
    }

}