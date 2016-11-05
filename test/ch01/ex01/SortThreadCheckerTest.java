package ch01.ex01;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SortThreadCheckerTest {

    private BufferedReader reader;

    @Before
    public void setup() throws IOException {
        PipedInputStream pin = new PipedInputStream();
        reader = new BufferedReader(new InputStreamReader(pin));
        System.setOut(new PrintStream(new PipedOutputStream(pin)));
    }

    @Test
    public void checkTest() throws IOException {
        new SortThreadChecker().check();
        String line;
        assertEquals("Sort Start", reader.readLine());
        while ((line = reader.readLine()) != null && !line.equals("Sort End")) {
            assertTrue(line.matches("(Called|Caller) thread: name=.*, id=\\d+"));
        }
    }

}