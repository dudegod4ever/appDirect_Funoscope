package funoscope.web.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ZodiacSign {

    AQUARIUS("aquarius"),
    PISCES("pisces"),
    ARIES("aries"),
    TAURUS("taurus"),
    GEMINI("gemini"),
    CANCER("cancer"),
    LEO("leo"),
    VIRGO("virgo"),
    LIBRA("libra"),
    SCORPIO("scorpio"),
    SAGITTARIUS("sagittarius"),
    CAPRICORN("capricorn");

    private final String label;

    private ZodiacSign(String pLabel) {
        this.label = pLabel;
    }

    public String getLabel() {
        return label;
    }

    private static final List<ZodiacSign> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static ZodiacSign getRandomZodiacSign() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

}
