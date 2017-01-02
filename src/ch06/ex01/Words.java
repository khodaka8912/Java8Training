package ch06.ex01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author hodaka
 */
public class Words {

    static String getLongestWordParallel(String[] words) {
        AtomicReference<String> longest = new AtomicReference<>("");
        Arrays.stream(words).parallel()
                .forEach(s -> longest.accumulateAndGet(s, (s1, s2) -> s1.length() > s2.length() ? s1 : s2));
        return longest.get();
    }

    public static void main(String[] args) throws IOException {
        String[] words = new String(
                Files.readAllBytes(Paths.get("war_and_peace.txt"))
        ).split("[\\P{L}]+");
        String longestWord = getLongestWordParallel(words);
        System.out.println("The longest word is : " + longestWord);
    }
}
