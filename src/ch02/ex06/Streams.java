package ch02.ex06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author hodaka
 */
public class Streams {

    private Streams() {
    }

    static Stream<Character> characterStream(String string) {
        return IntStream.range(0, string.length()).mapToObj(i -> string.charAt(i));
    }

    public static void main(String[] args) {
        characterStream("abcdefgh").forEach(c -> System.out.printf("%c, ", c));
    }
}
