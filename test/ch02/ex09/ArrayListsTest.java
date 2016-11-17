package ch02.ex09;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

/**
 * @author hodaka
 */
public class ArrayListsTest {

    @Test
    public void testToArrayList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<ArrayList<Integer>> arrayLists = new ArrayList<>();
        arrayLists.add(new ArrayList<Integer>(list.subList(0, 3)));
        arrayLists.add(new ArrayList<Integer>(list.subList(3, 6)));
        arrayLists.add(new ArrayList<Integer>(list.subList(6, 9)));
        Stream<ArrayList<Integer>> stream = arrayLists.stream();

        ArrayList<Integer> result = ArrayLists.toArrayList(stream);

        for (int i = 0; i < list.size(); i++) {
            assertTrue(result.get(i) == list.get(i));
        }
    }

}