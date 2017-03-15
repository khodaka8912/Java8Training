package ch09.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * {@link Scanner#close()} and {@link PrintWriter#close()} never throw any exception.
 *
 * @author hodaka
 */
public class IOUtils {

    public static void tryWithoutResources(String fromPath, String toPath) throws IOException {
        Scanner in;
        PrintWriter out;

        in = new Scanner(Paths.get(fromPath));
        try {
            out = new PrintWriter(toPath);
        } finally {
            in.close();
        }

        try {
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } finally {
            in.close();
            out.close();
        }
    }
}
