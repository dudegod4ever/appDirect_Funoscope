package funoscope.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import funoscope.http.HttpClient;
import funoscope.util.FunoscopeStringGenUtil;
import funoscope.web.WebConstants;

@RestController
@RequestMapping(WebConstants.URL_FUNOSCOPE_BASE)
public class FunoscopeController {

    @Autowired
    private HttpClient httpClient;

    @RequestMapping(value = WebConstants.URL_FUNOSCOPE_GET, method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getFunoscope(@PathVariable(WebConstants.VERSION) String pVersion, HttpServletResponse pResponse) {

        return FunoscopeStringGenUtil.getQuote(httpClient);
    }

}
