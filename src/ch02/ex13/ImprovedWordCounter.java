package ch02.ex13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author hodaka
 */
public class ImprovedWordCounter {

    static Map<Integer, Long> countShortWords(Stream<String> words, int max) {
        Map<Integer, Long> shortWords = words.parallel().filter(s -> s.length() < max)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        shortWords.entrySet().forEach(System.out::println);
        return shortWords;
    }

    public static void main(String[] args) throws IOException {
        Stream<String> words = Arrays.asList(
                new String(
                        Files.readAllBytes(Paths.get("alice.txt"))
                ).split("[\\P{L}]+")
        ).stream();
        countShortWords(words, 12);
    }
}
