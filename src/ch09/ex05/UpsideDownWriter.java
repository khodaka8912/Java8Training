package ch09.ex05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author hodaka
 */
public class UpsideDownWriter {

    private UpsideDownWriter() {
    }

    public static void copyChars(Path fromPath, Path toPath) throws IOException {
        String chars = new StringBuilder(new String(Files.readAllBytes(fromPath))).reverse().toString();
        Files.write(toPath, chars.getBytes());
    }

    public static void main(String[] args) throws IOException {
        Path from = Paths.get("alice.txt");
        Path to = Paths.get("alice_char_reversed.txt");
        copyChars(from, to);
    }
}
