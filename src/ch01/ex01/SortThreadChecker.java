package ch01.ex01;

import java.util.Arrays;
import java.util.Comparator;

public class SortThreadChecker {

    private String[] target = {"aaaa", "aaa", "abcde", "123456", "x", "00"};

    void check() {
        Comparator<String> checker = (s1, s2) -> {
            System.out.println("Called thread: " + currentThreadInfo());
            return s1.length() == s2.length() ? 0 :
                    s1.length() > s2.length() ? 1 :
                            -1;
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
