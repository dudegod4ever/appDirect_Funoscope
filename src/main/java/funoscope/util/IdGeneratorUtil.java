package funoscope.util;

import java.util.Random;

import org.apache.commons.codec.binary.Hex;

public class IdGeneratorUtil {
    public final static String MINUS = "-";

    public static String getSubscriptionId() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getEncodedString(4));
        buffer.append(MINUS);
        buffer.append(getEncodedString(2));
        buffer.append(MINUS);
        buffer.append(getEncodedString(2));
        buffer.append(MINUS);
        buffer.append(getEncodedString(2));
        buffer.append(MINUS);
        buffer.append(getEncodedString(6));

        return buffer.toString();
    }

    public static String getUserId() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getEncodedString(4));
        buffer.append(MINUS);
        buffer.append(getEncodedString(2));
        buffer.append(MINUS);
        buffer.append(getEncodedString(2));
        buffer.append(MINUS);
        buffer.append(getEncodedString(2));
        buffer.append(MINUS);
        buffer.append(getEncodedString(6));

        return buffer.toString();
    }

    public static String getCompanyId() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getEncodedString(4));
        buffer.append(MINUS);
        buffer.append(getEncodedString(2));
        buffer.append(MINUS);
        buffer.append(getEncodedString(2));
        buffer.append(MINUS);
        buffer.append(getEncodedString(2));
        buffer.append(MINUS);
        buffer.append(getEncodedString(6));

        return buffer.toString();
    }

    private static String getEncodedString(int pSize) {
        byte[] resBuf = new byte[pSize];
        new Random().nextBytes(resBuf);
        return new String(Hex.encodeHex(resBuf));
    }
}
