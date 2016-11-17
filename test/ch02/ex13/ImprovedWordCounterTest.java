package ch02.ex13;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

/**
 * @author hodaka
 */
public class ImprovedWordCounterTest {

    @Test
    public void testCountShortWords() throws IOException {
        Stream<String> words = Arrays.asList(
                new String(
                        Files.readAllBytes(Paths.get("alice.txt"))
                ).split("[\\P{L}]+")
        ).stream();

        Map<Integer, Long> shortWords = ImprovedWordCounter.countShortWords(words, 12);

        assertTrue(shortWords.entrySet().size() == 12);
    }

}