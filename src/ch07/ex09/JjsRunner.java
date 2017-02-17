package ch07.ex09;

import java.io.IOException;

/**
 * @author hodaka
 */
public class JjsRunner {

    private static final String JS_FILE_PATH = "src/ch07/ex09/nextYear.js";

    public static void main(String[] args) throws IOException, InterruptedException {

        Process process = new ProcessBuilder()
                .command("jjs", JS_FILE_PATH, "--", "27")
                .redirectErrorStream(true)
                .inheritIO()
                .start();
        process.waitFor();
    }
}
