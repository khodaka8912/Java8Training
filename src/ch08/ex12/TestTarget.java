package ch08.ex12;

/**
 * @author hodaka
 */
public class TestTarget {

    @TestCase(param = 1, expected = 2)
    public int doubleOf(int value) {
        return value << 1;
    }

    @TestCase(param = 5, expected = 25)
    public int pow2(int value) {
        return (int) Math.pow(value, 2);
    }

    @TestCase(param = 0, expected = -5)
    public int minus5(int value) {
        // Wrong calc
        return value + 5;
    }
}
