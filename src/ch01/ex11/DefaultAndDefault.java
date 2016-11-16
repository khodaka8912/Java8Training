package ch01.ex11;

/**
 * @author hodaka
 */
public class DefaultAndDefault {

    interface I {
        default void f() {
            System.out.println("I#f");
        }
    }

    interface J {
        default void f() {
            System.out.println("J#f");
        }
    }

    static class S {
        public void f() {
            System.out.println("S#f");
        }
    }

    static class K implements I, J {
        /**
         * needs override
         */
        @Override
        public void f() {
            System.out.println("K#f");
        }
    }

    static class L extends S implements I {

    }

    public static void main(String[] args) {
        new K().f();
        new L().f();
    }
}
