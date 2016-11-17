package ch02.ex02;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author hodaka
 */
public class FilterCheckerTest {
    @Test
    public void testFindLongWords() throws Exception {
        List<String> words = Arrays.asList(
                new String(
                        Files.readAllBytes(Paths.get("alice.txt"))
                ).split("[\\P{L}]+")
        );

        List<String> found = FilterChecker.findLongWords(words, 5);

        assertTrue(found.size() <= 5);
        found.forEach(s -> assertTrue(s.length() > FilterChecker.LENGTH));
    }

}