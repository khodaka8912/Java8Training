package ch08.ex07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hodaka
 */
public class Comparators {

    /**
     * Equivalent to Comparator.nullsFirst(Comparator.naturalOrder()).reversed().
     *
     * @param <T> the type of elements to be compared that implements Comparable
     * @return a comparator that considers null to be greater than non-null,
     * and compares non-null with the reverse of the natural ordering on  Comparable objects.
     */
    static <T extends Comparable<? super T>> Comparator<T> reversedAndNullsLast() {
        return Comparator.nullsLast(Comparator.reverseOrder());
    }

    public static void main(String[] args) {
        String[] words = {"aaaab", "12345", "efg", "abcdefg", "AAA"};
        String[] target1 = words.clone();
        String[] target2 = words.clone();

        Arrays.sort(target1, Comparator.nullsFirst(Comparator.<String>naturalOrder()).reversed());
        Arrays.sort(target2, reversedAndNullsLast());

        for (int i = 0; i < words.length; i++) {
            if (!target1[i].equals(target2[i])) {
                throw new AssertionError("Sort result is not equivalent.");
            }
        }
        System.out.println("Compare test passes.");
    }
}
