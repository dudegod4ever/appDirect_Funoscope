package funoscope.util;

import java.util.Random;

import funoscope.web.WebConstants;
import funoscope.web.enumeration.ZodiacSign;

public class FunoscopeStringGenUtil {

    private static Random weekRandomizer = new Random();
    private static Random yearRandomizer = new Random();

    public static String getFunoscopeString() {

        Integer week = weekRandomizer.nextInt(52) + 1;
        Integer year = yearRandomizer.nextInt(2) + 2014;

        String zodiacSign = ZodiacSign.getRandomZodiacSign().getLabel();

        return WebConstants.HTTP_FUNOSCOPE + WebConstants.SLASH + year + WebConstants.SLASH + week + WebConstants.SLASH + zodiacSign;

    }
}
