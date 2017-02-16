package ch08.ex05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author hodaka
 */
public class WordCounter {

    static long countLongWordsWithoutStream(List<String> words) {
        LongAdder adder = new LongAdder();
        words.forEach(s -> {
            if (s.length() > 12) {
                adder.increment();
            }
        });
        return adder.sum();
    }

    public static void main(String[] args) throws IOException {

        List<String> words = Arrays.asList(
                new String(
                        Files.readAllBytes(Paths.get("war_and_peace.txt"))
                ).split("[\\P{L}]+")
        );
        long count = countLongWordsWithoutStream(words);
        System.out.println("Long words are : " + count);
    }
}
