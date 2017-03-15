package ch09.ex07;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author hodaka
 */
public class WebUtils {

    public static void saveToFile(URL url, Path target) throws IOException {
        Files.copy(url.openStream(), target);
    }

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com/");
        Path target = Paths.get("google.html");
        saveToFile(url, target);
    }
}
