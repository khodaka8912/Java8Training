package ch02.ex01;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author hodaka
 */
public class ParallelForLoopTest {
    @Test
    public void testCountLongWord() throws Exception {
        List<String> words = Arrays.asList(
                new String(
                        Files.readAllBytes(Paths.get("src\\ch02\\ex01\\ParallelForLoop.java"))
                ).split("[\\P{L}]+")
        );
        int count = 0;
        for (String word : words) {
            if (word.length() > ParallelForLoop.LENGTH) {
                count++;
            }
        }

        int actual = ParallelForLoop.countLongWord(words);

        assertEquals(count, actual);
    }

}