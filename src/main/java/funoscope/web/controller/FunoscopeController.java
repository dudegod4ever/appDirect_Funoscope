package funoscope.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import funoscope.http.HttpClient;
import funoscope.util.FunoscopeStringGenUtil;
import funoscope.web.WebConstants;
import funoscope.web.domain.ZodiacQuote;

@RestController
@RequestMapping(WebConstants.URL_FUNOSCOPE_BASE)
public class FunoscopeController {

    @Autowired
    private HttpClient HttpClient;

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = WebConstants.URL_FUNOSCOPE_GET, method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getFunoscope(@PathVariable(WebConstants.VERSION) String pVersion, HttpServletResponse pResponse) {

        return getQuote();
    }

    private String getQuote() {
        String response = null;
        for (int i = 0; i < 10; i++) {
            try {
                response = HttpClient.sendRequest(FunoscopeStringGenUtil.getFunoscopeString());
                ZodiacQuote zodiacQuote = objectMapper.readValue(response, ZodiacQuote.class);
                response = zodiacQuote.getPrediction();
                break;
            } catch (Exception ex) {
                // not all generated links have values 
                //retry
            }
        }

        if (response == null) {
            response = "Live long and may the force be with the one ring.";
        }

        return response;
    }

}
