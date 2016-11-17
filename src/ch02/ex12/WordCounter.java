package ch02.ex12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author hodaka
 */
public class WordCounter {

    private WordCounter() {
    }

    static int[] countShortWords(Stream<String> words, int max) {
        AtomicInteger[] shortWords = new AtomicInteger[max];
        for (int i = 0; i < max; i++) {
            shortWords[i] = new AtomicInteger();
        }
        words.parallel().forEach(s -> {
            if (s.length() < max) {
                shortWords[s.length()].incrementAndGet();
            }
        });
        System.out.println(Arrays.toString(shortWords));
        return Arrays.stream(shortWords).mapToInt(a -> a.get()).toArray();
    }

    public static void main(String[] args) throws IOException {
        List<String> words = Arrays.asList(
                new String(
                        Files.readAllBytes(Paths.get("alice.txt"))
                ).split("[\\P{L}]+")
        );
        countShortWords(words.stream(), 12);
    }
}
