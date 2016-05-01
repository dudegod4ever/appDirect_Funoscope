package funoscope.http;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class HttpClient {

    public String sendRequest(String pTargetURL) throws Exception {
        String responseBody = null;
        URLConnection connection;
        try {
            connection = new URL(pTargetURL).openConnection();

            connection.setRequestProperty("Accept-Charset", StandardCharsets.UTF_8.name());
            InputStream response = connection.getInputStream();

            Scanner scanner = new Scanner(response);
            responseBody = scanner.useDelimiter("\\A").next();
            scanner.close();
        } catch (Exception e) {
            System.out.println("target Url failed for " + pTargetURL);
        }

        return responseBody;
    }
}
