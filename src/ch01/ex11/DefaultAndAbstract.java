package ch01.ex11;

/**
 * @author hodaka
 */
public class DefaultAndAbstract {

    interface I {
        default void f() {
            System.out.println("I#f");
        }
    }

    interface J {
        void f();
    }

    static class S {
        public void f() {
            System.out.println("S#f");
        }
    }

    static abstract class T {
        public abstract void f();
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

    static class L extends T implements I {
        /**
         * needs override
         */
        @Override
        public void f() {
            System.out.println("T#f");
        }
    }

    static class M extends S implements J {

    }

    public static void main(String[] args) {
        new K().f();
        new L().f();
        new M().f();
    }
}
