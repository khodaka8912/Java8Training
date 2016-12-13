package ch01.ex07;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author hodaka
 */
public class ContinuousRunnerTest {
    @Test
    public void testAndThen() throws Exception {
        final List<String> list = new ArrayList<>();

        ContinuousRunner.andThen(() -> list.add("first"), () -> list.add("second")).run();

        assertEquals(2, list.size());
        assertEquals("first", list.get(0));
        assertEquals("second", list.get(1));
    }
}