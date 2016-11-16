package ch01.ex11;

/**
 * @author hodaka
 */
public class StaticAndStatic {

    interface I {
        static void f() {
            System.out.println("I#f");
        }
    }

    interface J {
        static void f() {
            System.out.println("I#f");
        }
    }

    static class S {
        static void f() {
            System.out.println("S#f");
        }
    }

    static class K implements I, J {
    }

    static class L extends S implements I {

    }

    public static void main(String[] args) {
        L.f();
    }
}
