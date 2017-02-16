package ch08.ex10;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author hodaka
 */
public class JavaWalker {

    private static final String LOCAL_PATH_OF_SRC = "C:\\Users\\hodaka\\src";

    static void walkForTransientAndVolatile(Path path) throws IOException {
        Files.walk(path, FileVisitOption.FOLLOW_LINKS).filter(p -> {
            try {
                List<String> words = Arrays.asList(
                        new String(
                                Files.readAllBytes(p)
                        ).split("[\\P{L}]+")
                );
                boolean isFound = false;
                for (String word : words) {
                    if (word.equals("transient") || word.equals("volatile")) {
                        isFound = true;
                    }
                }
                return isFound;
            } catch (IOException e) {
                return false;
            }
        }).map(p -> {
            String string = p.toString();
            return string.substring(string.indexOf("src\\"));
        }).forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        walkForTransientAndVolatile(Paths.get(LOCAL_PATH_OF_SRC));
    }
}
