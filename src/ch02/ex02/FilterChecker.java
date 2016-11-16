package ch02.ex02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author hodaka
 */
public class FilterChecker {

    static final int LENGTH = 12;

    static List<String> findLongWords(List<String> words, int limit) {
        AtomicInteger count = new AtomicInteger();
        return words.stream().filter(s -> {
            if (s.length() > LENGTH) {
                System.out.println("find long word.S count = " + count.incrementAndGet());
            } else {
                System.out.println("not long.");
            }
            return s.length() > LENGTH;
        }).limit(limit).collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        List<String> words = Arrays.asList(
                new String(
                        Files.readAllBytes(Paths.get("alice.txt"))
                ).split("[\\P{L}]+")
        );
        List<String> filtered = findLongWords(words, 5);
        filtered.forEach(System.out::println);
    }
}
