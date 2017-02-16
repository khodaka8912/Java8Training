package ch08.ex15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

/**
 * @author hodaka
 */
public class Grep {

    public static void main(String... args) throws IOException {
        Files.lines(Paths.get(args[1])).filter(Pattern.compile(args[0]).asPredicate()).forEach(System.out::println);
    }
}
