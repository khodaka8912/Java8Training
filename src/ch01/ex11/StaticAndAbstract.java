package ch01.ex11;

/**
 * @author hodaka
 */
public class StaticAndAbstract {

    interface I {
        static void f() {
            System.out.println("I#f");
        }
    }

    interface J {
        void f();
    }

    static class S {
        static void f() {
            System.out.println("S#f");
        }
    }

    static abstract class T {
        public abstract void f();
    }

    static class K implements I, J {
        /* needs override */
        @Override
        public void f() {
            System.out.println("K#f");
        }
    }

    /**
     * Compile error
     */
//    static class L extends S implements J {
//    }

    static class M extends T implements I {
        /**
         * needs override
         */
        @Override
        public void f() {
            System.out.println("M#f");
        }
    }

    public static void main(String[] args) {
        new K().f();
        new M().f();
    }
}
