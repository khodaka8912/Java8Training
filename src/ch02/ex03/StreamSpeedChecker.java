package ch02.ex03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author hodaka
 */
public class StreamSpeedChecker {

    static long mesure(Stream<?> stream) {
        long start = System.nanoTime();
        long count = stream.count();
        long end = System.nanoTime();
        System.out.println("count = " + count);
        return end - start;
    }

    public static void main(String[] args) throws IOException {
        List<String> words = Arrays.asList(
                new String(
                        Files.readAllBytes(Paths.get("war_and_peace.txt"))
                ).split("[\\P{L}]+")
        );
        Stream<String> sequential = words.stream().filter(s -> s.length() > 12);
        Stream<String> parallel = words.parallelStream().filter(s -> s.length() > 12);
        long sequentialTime = mesure(sequential);
        long parallelTime = mesure(parallel);
        System.out.println("Sequential: " + (double) sequentialTime / 1000 / 1000 + "[ms]");
        System.out.println("Parallel: " + (double) parallelTime / 1000 / 1000 + "[ms]");
    }
}
