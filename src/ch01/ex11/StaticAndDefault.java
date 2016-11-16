package ch01.ex11;

/**
 * @author hodaka
 */
public class StaticAndDefault {

    interface I {
        static void f() {
            System.out.println("I#f");
        }
    }

    interface J {
        default void f() {
            System.out.println("J#f");
        }
    }

    static class S {
        static void f() {
            System.out.println("S#f");
        }
    }

    static class T {
        public void f() {
            System.out.println("T#f");
        }
    }

    static class K implements I, J {
    }

    /**
     * Compile error
     */
//    static class L extends S implements J {
//
//    }

    static class M extends T implements I {

    }

    public static void main(String[] args) {
        new K().f();
        new M().f();
    }
}
