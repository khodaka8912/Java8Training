package ch01.ex02;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DirectoryUtils {

    private DirectoryUtils() {
    }

    /**
     * Show sub directories in the path.
     * Internally, using Lambda
     *
     * @param directoryPath path to show sub directories.
     * @throws NullPointerException if directoryPath is null.
     * @throws IllegalArgumentException if directoryPath is not a directory.
     */
    public static List<File> listSubDirectoriesLambda(String directoryPath) {
        File dir = checkPath(directoryPath);
        File[] subDirs = dir.listFiles(f -> f.isDirectory());
        return Arrays.asList(subDirs);
    }

    /**
     * Show sub directories in the path.
     * Internally, using method reference.
     *
     * @param directoryPath path to show sub directories.
     * @throws NullPointerException if directoryPath is null.
     * @throws IllegalArgumentException if directoryPath is not a directory.
     */
    public static List<File> listSubDirectoriesMethodRef(String directoryPath) {
        File dir = checkPath(directoryPath);
        File[] subDirs = dir.listFiles(File::isDirectory);
        return Arrays.asList(subDirs);
    }

    private static File checkPath(String directoryPath) {
        Objects.requireNonNull(directoryPath, "path must not be null.");
        File file = new File(directoryPath);
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("path must be a directory");
        }
        return file;
    }

    public static void main(String[] args) {
        listSubDirectoriesLambda("src").forEach(System.out::println);
        listSubDirectoriesMethodRef("test").forEach(System.out::println);
    }

}
