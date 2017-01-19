package ch06.ex06;

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
import java.util.function.Function;

/**
 * {@link Map#computeIfAbsent(Object, Function)}を利用するパターン。
 * この場合、すでにSetがある場合、新たにSetを生成するコストが減らせる。
 *
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
        for (File file : files) {
            executorService.execute(() -> {
                String[] words = readWords(file);
                for (String word : words) {
                    Set<File> collected = wordMap.computeIfAbsent(word, s -> new HashSet<>());
                    synchronized (collected) {
                        collected.add(file);
                    }
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
