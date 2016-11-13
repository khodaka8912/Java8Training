package ch01.ex09;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author hodaka
 */
public class Collection2Test {

    private static class ArrayList2<E> extends ArrayList<E> implements Collection2<E> {

    }

    @Test
    public void testForEachIf() {
        ArrayList2<String> list = new ArrayList2<>();
        list.addAll(Arrays.asList("a1", "a2", "b1", "a3", "c1"));
        List<String> filtered = new ArrayList<>();

        list.forEachIf(s -> filtered.add(s), s -> s.startsWith("a"));

        assertEquals(3, filtered.size());
        filtered.forEach(s -> assertTrue(s.startsWith("a")));
    }

}