package ch07.ex08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author hodaka
 */
public class JjsRunner {

    private static final String JS_FILE_PATH = "src/ch07/ex08/show_env.js";

    public static void main(String[] args) throws IOException, InterruptedException {

        Process process = new ProcessBuilder()
                .command("jjs", "-scripting", JS_FILE_PATH)
                .redirectErrorStream(true)
                .start();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        process.waitFor();
    }
}
