package ch01.ex11;

/**
 * @author hodaka
 */
public class AbstractAndAbstract {

    interface I {
        void f();
    }

    interface J {
        void f();
    }

    static abstract class S {
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

    static class L extends S implements I {
        /**
         * needs override
         */
        @Override
        public void f() {
            System.out.println("L#f");
        }
    }

    public static void main(String[] args) {
        new K().f();
        new L().f();
    }
}
