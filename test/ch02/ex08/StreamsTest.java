package ch02.ex08;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author hodaka
 */
public class StreamsTest {

    Integer[] first = {1, 3, 5, 7, 9, 11};
    Integer[] second = {2, 4, 6, 8};
    Integer[] zip = {1, 2, 3, 4, 5, 6, 7, 8};

    @Test
    public void testZipCount() {
        long count = Streams.zip(Arrays.stream(first), Arrays.stream(second)).count();

        assertTrue("count = " + count, count == 9);
    }


    @Test
    public void testZipCollect() {
        List<Integer> result = Streams.zip(Arrays.stream(first), Arrays.stream(second)).collect(Collectors.toList());

        assertTrue("size = " + result.size(), result.size() == 9);
        for (int i = 0; i < zip.length; i++) {
            assertTrue(result.get(i) == zip[i]);
        }
    }

    @Test
    public void testZipMap() {
        List<String> result = Streams.zip(Arrays.stream(first), Arrays.stream(second)).map(i -> i.toString() + i.toString()).collect(Collectors.toList());

        for (int i = 0; i < zip.length; i++) {
            assertEquals(zip[i].toString() + zip[i].toString(), result.get(i));
        }
    }

}