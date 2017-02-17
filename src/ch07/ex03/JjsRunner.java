package ch07.ex03;

import java.io.IOException;

/**
 * @author hodaka
 */
public class JjsRunner {

    private static final String JS_FILE_PATH = "src/ch07/ex03/big_integer.js";

    public static void main(String[] args) throws IOException, InterruptedException {

        Process process = new ProcessBuilder()
                .command("jjs", JS_FILE_PATH)
                .redirectErrorStream(true)
                .inheritIO()
                .start();
        process.waitFor();
    }
}
