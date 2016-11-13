package ch01.ex02;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class DirectorySearcher {

    private DirectorySearcher() {
    }

    /**
     * Show sub directories in the path.
     * Internally, using Lambda
     *
     * @param directoryPath path to show sub directories.
     */
    public static void showSubDirectoriesLambda(String directoryPath) {
        Objects.requireNonNull(directoryPath, "path must not be null.");
        File file = new File(directoryPath);
        if (!file.isDirectory()) {
            System.out.println("\"" + directoryPath + "\" is not a directory.");
            return;
        }
        File[] subDirStream = file.listFiles(f -> f.isDirectory());
        System.out.println("Sub directories in \"" + directoryPath + "\" are:");
        Arrays.stream(subDirStream).map(f -> f.getName()).forEach(s -> System.out.println(s));
    }

    /**
     * Show sub directories in the path.
     * Internally, using method reference.
     *
     * @param directoryPath path to show sub directories.
     */
    public static void showSubDirectoriesMethodReference(String directoryPath) {
        Objects.requireNonNull(directoryPath, "path must not be null.");
        File file = new File(directoryPath);
        if (!file.isDirectory()) {
            System.out.println("\"" + directoryPath + "\" is not a directory.");
            return;
        }
        File[] subDirStream = file.listFiles(File::isDirectory);
        System.out.println("Sub directories in \"" + directoryPath + "\" are:");
        Arrays.stream(subDirStream).map(File::getName).forEach(System.out::println);
    }

    public static void main(String[] args) {
        String path = "C:\\Program Files";
        showSubDirectoriesLambda(path);
        showSubDirectoriesMethodReference("C:\\Program Files\\Java\\jdk1.8.0_65\\LICENSE");
    }

}
