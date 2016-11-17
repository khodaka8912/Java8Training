package ch02.ex01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hodaka
 */
public class ParallelForLoop {

    private static final int THREAD_NUM = 5;
    static final int LENGTH = 12;

    static class CounterThread extends Thread {

        private final List<String> words;
        private int count;

        CounterThread(List<String> words) {
            this.words = words;
        }

        @Override
        public void run() {
            for (String word : words) {
                if (word.length() > LENGTH) {
                    count++;
                    System.out.println(word);
                }
            }
        }

        int getResult() {
            try {
                join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return count;
        }
    }

    static int countLongWord(List<String> words) {
        int listSize = words.size();
        int segmentSize = (int) Math.ceil((double) listSize / THREAD_NUM);
        List<CounterThread> counterThreads = new ArrayList<>();
        for (int i = 0; i < THREAD_NUM; i++) {
            int start = segmentSize * i;
            int end = Math.min(segmentSize * (i + 1), listSize);
            if (start >= listSize) {
                break;
            }
            CounterThread thread = new CounterThread(words.subList(start, end));
            thread.start();
            counterThreads.add(thread);
        }
        int total = 0;
        for (CounterThread thread : counterThreads) {
            total += thread.getResult();
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        List<String> words = Arrays.asList(
                new String(
                        Files.readAllBytes(Paths.get("alice.txt"))
                ).split("[\\P{L}]+")
        );
        int count = countLongWord(words);
        System.out.println("count = " + count);
    }
}
