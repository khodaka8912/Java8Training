package ch06.ex05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author hodaka
 */
public class WordCollector {

    static String[] readWords(File file) {
        try {
            return new String(
                    Files.readAllBytes(file.toPath())
            ).split("[\\P{L}]+");
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    static Map<String, Set<File>> collect(File... files) {
        ConcurrentHashMap<String, Set<File>> wordMap = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(files.length);
        for (File f : files) {
            executorService.execute(() -> {
                String[] words = readWords(f);
                Set<File> file = new HashSet<>();
                file.add(f);
                for (String word : words) {
                    wordMap.merge(word, file, (s1, s2) -> {
                        s1.addAll(s2);
                        return s1;
                    });
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return wordMap;
    }

    public static void main(String[] args) {
        Map<String, Set<File>> words = collect(new File("alice.txt"), new File("war_and_peace.txt"));
        words.forEach((word, files) -> {
            System.out.println("\"" + word + "\" was found in " + files);
        });
    }
}
