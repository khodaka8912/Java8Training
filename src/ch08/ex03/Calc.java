package ch08.ex03;

/**
 * @author hodaka
 */
public class Calc {

    private Calc() {
    }

    static int gcd(int a, int b) {
        if (a == 0) {
            return Math.abs(b);
        } else if (b == 0) {
            return Math.abs(a);
        } else {
            return gcd(b, a % b);
        }
    }

    static int gcd2(int a, int b) {
        if (a == 0) {
            return Math.abs(b);
        } else if (b == 0) {
            return Math.abs(a);
        } else {
            return gcd2(b, Math.floorMod(a, b));
        }
    }

    static int gcd3(int a, int b) {
        if (a == 0) {
            return Math.abs(b);
        } else if (b == 0) {
            return Math.abs(a);
        } else {
            return gcd3(b, a % b);
        }
    }

    static int rem(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("cannot divide with 0");
        }
        if (a > 0) {
            return a % b;
        } else if (b > 0) {
            return Math.floorMod(a, b);
        } else {
            return a - b * (a / b - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(12, 63));
        System.out.println(gcd(-15, 25));
        System.out.println(gcd(12, 12));
        System.out.println(gcd(-15, -25));
    }
}
