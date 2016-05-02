package funoscope.util;

import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;

import funoscope.http.HttpClient;
import funoscope.web.WebConstants;
import funoscope.web.domain.ZodiacQuote;
import funoscope.web.enumeration.ZodiacSign;

public class FunoscopeStringGenUtil {

    private static Random weekRandomizer = new Random();
    private static Random yearRandomizer = new Random();
    private static Random errorRandomizer = new Random();

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String quotes[] =
        { "Live long and may the force be with the one ring.", "Getting old is never easy, but take heart, help will soon be on its way.",
          "You'll finally get a taste of your own medicine this week, which is unfortunate, as you're the nation's leading supplier of horse laxatives.",
          "The stars, in their infinite wisdom, indicate that you have something on your shirt. Also the stars indicate that you always fall for that one.",
          "Regret will be yours this week when you're forced to choose between a slice of cherry pie and everlasting life.",
          "They say there's plenty of fish in the sea, but everything you catch is either covered in scales, has concentrated levels of mercury, or suffers from deep-seated abandonment issues.",
          "After years of being an emotionless drone, you'll finally break down and cry this week, instantly rusting your metal hinges and joints.",
          "You've always wondered what kind of father you'd be. Now with the children out of the way, you'll have plenty of time to figure it out.",
          "Remember: A penny saved is a harsh and unflattering reputation earned." };

    public static String getQuote(HttpClient pHttpClient) {
        String response = null;
        String funoscopeString = FunoscopeStringGenUtil.getFunoscopeString();

        if (pHttpClient.pingHost(funoscopeString, 80, 5000)) {
            for (int i = 0; i < 10; i++) {
                try {
                    response = pHttpClient.sendRequest(FunoscopeStringGenUtil.getFunoscopeString());
                    ZodiacQuote zodiacQuote = objectMapper.readValue(response, ZodiacQuote.class);
                    response = zodiacQuote.getPrediction();
                    break;
                } catch (Exception ex) {
                    // not all generated links have values 
                    //retry
                }
            }
        }

        if (response == null) {
            System.out.println("The REST server is down, inspire anyway!");
            int index = errorRandomizer.nextInt(quotes.length);
            response = quotes[index];
        }

        return response;
    }

    private static String getFunoscopeString() {

        Integer week = weekRandomizer.nextInt(52) + 1;
        Integer year = yearRandomizer.nextInt(2) + 2014;

        String zodiacSign = ZodiacSign.getRandomZodiacSign().getLabel();

        return WebConstants.HTTP_FUNOSCOPE + WebConstants.SLASH + year + WebConstants.SLASH + week + WebConstants.SLASH + zodiacSign;

    }
}
