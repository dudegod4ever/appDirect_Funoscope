package funoscope.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import funoscope.web.generatedxml.event.Event;

public class JaxbUtil {

    public static Event getEventFromResponseString(String pResponse) {
        Event event = null;

        JAXBContext jc;
        try {
            jc = JAXBContext.newInstance(Event.class);
            InputStream stream = new ByteArrayInputStream(pResponse.getBytes(StandardCharsets.UTF_8));
            event = (Event) jc.createUnmarshaller().unmarshal(stream);
        } catch (JAXBException e) {
            System.out.println("The event is null du to an error in JAXB : " + e.getMessage());
        }

        return event;
    }
}
