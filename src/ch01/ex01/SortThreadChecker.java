package ch01.ex01;

import java.util.Arrays;
import java.util.Comparator;

public final class SortThreadChecker {

    private String[] target = {"aaaa", "aaa", "abcde", "123456", "x", "00"};

    void check() {
        Comparator<String> checker = (s1, s2) -> {
            System.out.println("Called thread: " + currentThreadInfo());
            return Integer.compare(s1.length(), s2.length());
        };
        System.out.println("Sort Start");
        System.out.println("Caller thread: " + currentThreadInfo());
        Arrays.sort(target, checker);
        System.out.println("Sort End");
    }

    private static String currentThreadInfo() {
        Thread current = Thread.currentThread();
        return "name=" + current.getName() + ", id=" + current.getId();
    }

    public static void main(String[] args) {
        new SortThreadChecker().check();
    }
}
