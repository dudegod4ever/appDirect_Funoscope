package funoscope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import funoscope.web.WebConstants;

@SpringBootApplication
public class FunoscopeApplication {

    public static void main(String[] args) {
        if (args.length >= 2) {
            System.setProperty(WebConstants.FUNOSCOPE_CONSUMER_KEY, args[0]);
            System.setProperty(WebConstants.FUNOSCOPE_SECRET_KEY, args[1]);
        }
        if (args.length == 3) {
            System.setProperty(WebConstants.SKIP_AUTH_VALIDATION, args[2]);
        }
        SpringApplication.run(FunoscopeApplication.class, args);
    }

}
