package funoscope.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import funoscope.web.WebConstants;
import funoscope.web.adapter.SubscriptionAppDirectAdapter;
import funoscope.web.generatedxml.event.Event;

@RestController
@RequestMapping(WebConstants.URL_APPDIRECT_OAUTH_VALIDATION_BASE)
public class SubscriptionAppDirectStubController {

    @Autowired
    private SubscriptionAppDirectAdapter subscriptionAppDirectAdapter;

    @RequestMapping(value = WebConstants.URL_APPDIRECT_OAUTH_VALIDATION_STUB_BASE, method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public Event validOauthStub(@PathVariable(WebConstants.VERSION) String pVersion, @PathVariable(WebConstants.EVENT) String pEventToken,
                                HttpServletResponse pResponse) {

        //TODO Behaving like the server, it would have to authenticate the OAUTH signature

        Event event = subscriptionAppDirectAdapter.createSubscriptionOrderEventFromInputParameters(pVersion, pEventToken);

        return event;
    }

}
