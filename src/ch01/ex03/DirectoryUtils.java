package ch01.ex03;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DirectoryUtils {

    private DirectoryUtils() {
    }

    /**
     * List files in the directory that has the specified extension.
     *
     * @param directoryPath path to show files in it.
     * @param extension     extension to filter files, not includes ".".
     * @return List of files with the extension in the directory
     * @throws NullPointerException     if directoryPath or extension is null.
     * @throws IllegalArgumentException if directoryPath is not a directory.
     */
    public static List<String> listFilesByExtension(String directoryPath, String extension) {
        File dir = check(directoryPath, extension);
        /* The parameter "extension" is captured in lambda.  */
        String[] files = dir.list((f, s) -> s.endsWith("." + extension));
        return Arrays.asList(files);
    }

    private static File check(String directoryPath, String extension) {
        Objects.requireNonNull(directoryPath, "path must not be null.");
        Objects.requireNonNull(extension, "extension must not be null.");
        File file = new File(directoryPath);
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("path must be a directory");
        }
        return file;
    }

    public static void main(String[] args) {
        List<String> files = listFilesByExtension("src\\ch01\\ex03", "java");
        files.forEach(System.out::println);
    }
}
