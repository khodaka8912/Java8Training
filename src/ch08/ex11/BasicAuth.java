package ch08.ex11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 * @author hodaka
 */
public class BasicAuth {

    static String getAuthorizedPage(URL url, String user, String password) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString((user + ":" + password).getBytes());
        connection.setRequestProperty("Authorization", basicAuth);
        connection.setRequestMethod("GET");
        connection.connect();
        int status = connection.getResponseCode();
        System.out.println("status code: " + status);
        System.out.println("headers: " + connection.getHeaderFields());
        InputStream in;
        if (status < 200 || status >= 400) {
            in = connection.getErrorStream();
        } else {
            in = connection.getInputStream();
        }
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("-- Auth success pattern --");
        URL url = new URL("http://htaccess.cman.jp/sample_go/basic");
        System.out.println(getAuthorizedPage(url, "guest", "password"));

        System.out.println("-- Auth failure pattern --");
        System.out.println(getAuthorizedPage(url, "wrong user", "password"));
    }
}
