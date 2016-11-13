package ch01.ex04;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author hodaka
 */
public class FileUtils {

    private FileUtils() {
    }

    public static void sortByTypeAndName(File[] files) {
        Objects.requireNonNull(files, "files must not be null");
        Arrays.sort(files, (f1, f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) {
                return -1;
            } else if (!f1.isDirectory() && f2.isDirectory()) {
                return 1;
            } else {
                return f1.getPath().compareTo(f2.getPath());
            }
        });
    }

    public static void main(String[] args) {
        File[] files = {new File("README.md"), new File("test"), new File(".gitignore"), new File("src")};
        sortByTypeAndName(files);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
