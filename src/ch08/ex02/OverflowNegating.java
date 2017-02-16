package ch08.ex02;

/**
 * @author hodaka
 */
public class OverflowNegating {

    public static void main(String[] args) {
        System.out.println("negate " + Integer.MIN_VALUE);
        System.out.flush();
        try {
            Math.negateExact(Integer.MIN_VALUE);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }
}
