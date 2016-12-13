package ch03.ex07;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertTrue;

/**
 * @author hodaka
 */
public class StringComparatorsTest {

    final String[] testStrings = {"aaa", "aAbb", "a a c"};

    @Test
    public void testNatural() {
        Comparator<String> comparator = StringComparators.natural();

        assertTrue(comparator.compare(testStrings[0], testStrings[0]) == 0);
        assertTrue(comparator.compare(testStrings[0], testStrings[1]) > 0);
        assertTrue(comparator.compare(testStrings[0], testStrings[2]) > 0);
        assertTrue(comparator.compare(testStrings[1], testStrings[2]) > 0);
    }

    @Test
    public void testReverse() {
        Comparator<String> comparator = StringComparators.reverse((s1, s2) -> s1.length() - s2.length());

        assertTrue(comparator.compare(testStrings[0], testStrings[0]) == 0);
        assertTrue(comparator.compare(testStrings[0], testStrings[1]) > 0);
        assertTrue(comparator.compare(testStrings[0], testStrings[2]) > 0);
        assertTrue(comparator.compare(testStrings[1], testStrings[2]) > 0);
    }

    @Test
    public void testIgnoreCase() {
        Comparator<String> comparator = StringComparators.ignoreCase(StringComparators.natural());

        assertTrue(comparator.compare(testStrings[0], testStrings[0]) == 0);
        assertTrue(comparator.compare(testStrings[0], testStrings[1]) < 0);
        assertTrue(comparator.compare(testStrings[0], testStrings[2]) > 0);
        assertTrue(comparator.compare(testStrings[1], testStrings[2]) > 0);
    }

    @Test
    public void testIgnoreSpace() {
        Comparator<String> comparator = StringComparators.ignoreSpace(StringComparators.natural());

        assertTrue(comparator.compare(testStrings[0], testStrings[0]) == 0);
        assertTrue(comparator.compare(testStrings[0], testStrings[1]) > 0);
        assertTrue(comparator.compare(testStrings[0], testStrings[2]) < 0);
        assertTrue(comparator.compare(testStrings[1], testStrings[2]) < 0);
    }
}