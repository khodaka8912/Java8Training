package ch09.ex06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * @author hodaka
 */
public class UpsideDownWriter {

    private UpsideDownWriter() {
    }

    public static void copyLines(Path fromPath, Path toPath) throws IOException {
        List<String> lines = Files.readAllLines(fromPath);
        Collections.reverse(lines);
        Files.write(toPath, lines);
    }

    public static void main(String[] args) throws IOException {
        Path from = Paths.get("alice.txt");
        Path to = Paths.get("alice_line_reversed.txt");
        copyLines(from, to);
    }
}
