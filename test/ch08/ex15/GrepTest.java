package ch08.ex15;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author hodaka
 */
public class GrepTest {

    private List<String> lines = new ArrayList<>();

    @Before
    public void setup() throws IOException {
        PipedInputStream pin = new PipedInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(pin));
        System.setOut(new PrintStream(new PipedOutputStream(pin)));
        new Thread(() -> {
            String line;
            try {
                while ((line = reader.readLine()) != null && !line.equals("!END!")) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }


    @Test
    public void testMain() throws IOException {
        Grep.main("Rabbit", "alice.txt");
        System.out.println("!END!");
        for (String line : lines) {
            assertTrue(line.contains("Rabbit"));
        }
    }

}