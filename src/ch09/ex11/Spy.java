package ch09.ex11;

import java.io.IOException;

/**
 * @author hodaka
 */
public class Spy {

    public static void findCreditCardNumber(String path) throws IOException {
        Process process = new ProcessBuilder()
                .command("grep", "-r", "-I", "-E", "(\\d{16}|\\d{4}-\\d{4}-\\d{4}-\\d{4})", path)
                .inheritIO()
                .start();
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        findCreditCardNumber(System.getProperty("user.home"));
    }
}
