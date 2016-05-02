package funoscope.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.StringUtils;

import funoscope.web.generatedxml.event.Event;
import funoscope.web.generatedxml.event.Result;

public class JaxbUtil {

    public static Event getEventFromResponseString(String pResponse) {
        Event event = null;
        if (StringUtils.isNotEmpty(pResponse)) {

            JAXBContext jc;
            try {
                jc = JAXBContext.newInstance(Event.class);
                InputStream stream = new ByteArrayInputStream(pResponse.getBytes(StandardCharsets.UTF_8));
                event = (Event) jc.createUnmarshaller().unmarshal(stream);
            } catch (JAXBException e) {
                System.out.println("The event is null du to an error in JAXB : " + e.getMessage());
            }
        }
        return event;
    }

    public static Result getResultFromResponseString(String pResponse) {
        Result result = null;
        if (StringUtils.isNotEmpty(pResponse)) {

            JAXBContext jc;
            try {
                jc = JAXBContext.newInstance(Result.class);
                InputStream stream = new ByteArrayInputStream(pResponse.getBytes(StandardCharsets.UTF_8));
                result = (Result) jc.createUnmarshaller().unmarshal(stream);
            } catch (JAXBException e) {
                System.out.println("The event is null du to an error in JAXB : " + e.getMessage());
            }
        }

        return result;
    }
}
