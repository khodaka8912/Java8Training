package ch02.ex04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author hodaka
 */
public class SquareStream {

    public static void main(String[] args) {
        int[] values = {1, 4, 9, 16};
        Stream<int[]> intArrayStream = Stream.of(values);
        intArrayStream.forEach(System.out::println);

        IntStream intStream = IntStream.of(values);
        intStream.forEach(System.out::println);
    }
}
