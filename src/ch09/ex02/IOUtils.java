
package ch09.ex02;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author hodaka
 */
public class IOUtils {

    public static void tryWithoutResources(String fromPath, String toPath) throws IOException {
        Scanner in;
        PrintWriter out;

        in = new Scanner(Paths.get(fromPath));
        try {
            out = new PrintWriter(toPath);
        } catch (IOException e) {
            closeWithSuppress(in, e);
            throw e;
        }

        try {
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            closeWithSuppress(in, e);
            closeWithSuppress(out, e);
            throw e;
        }
        try {
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Exception closeWithSuppress(Closeable resource, Exception e) {
        try {
            resource.close();
        } catch (IOException e2) {
            e.addSuppressed(e2);
        }
        return e;
    }
}
