package ch08.ex01;

/**
 * @author hodaka
 */
public class UnsignedCalculator {

    static int add(int i1, int i2) {
        return i1 + i2;
    }

    static int sub(int i1, int i2) {
        return i1 - i2;
    }

    static int divide(int i1, int i2) {
        return Integer.divideUnsigned(i1, i2);
    }

    static int compare(int i1, int i2) {
        return i1 == i2 ? 0 :
                Integer.toUnsignedLong(i1) > Integer.toUnsignedLong(i2) ? 1 :
                        -1;
    }

    public static void main(String[] args) {
        String[] strs = {"1", "2222222222", "1111111111"};
        int[] ints = {Integer.parseUnsignedInt(strs[0]), Integer.parseUnsignedInt(strs[1]), Integer.parseUnsignedInt
                (strs[2])};
        System.out.printf("Representation of [%s,%s, %s] as int are: [%d, %d, %d]%n",
                strs[0], strs[1], strs[2], ints[0], ints[1], ints[2]);
        System.out.println("Add: ");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%10s + %10s = %10s%n", strs[i % 3], strs[(i + 1) % 3],
                    Integer.toUnsignedString(add(ints[i % 3], ints[(i + 1) % 3])));
        }
        System.out.println("Sub: ");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%10s - %10s = %10s%n", strs[i % 3], strs[(i + 1) % 3],
                    Integer.toUnsignedString(sub(ints[i % 3], ints[(i + 1) % 3])));
        }
        System.out.println("Divide: ");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%10s / %10s = %10s%n", strs[i % 3], strs[(i + 1) % 3],
                    Integer.toUnsignedString(divide(ints[i % 3], ints[(i + 1) % 3])));
        }
        System.out.println("Compare: ");
        for (int i = 0; i < 3; i++) {
            int comp = compare(ints[i % 3], ints[(i + 1) % 3]);
            System.out.printf("%10s %s %10s%n", strs[i % 3],
                    comp == 0 ? "==" : comp > 0 ? ">" : "<", strs[(i + 1) % 3]);
        }
    }
}
