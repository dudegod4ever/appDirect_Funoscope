package funoscope.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import funoscope.web.WebConstants;
import funoscope.web.generatedxml.event.Result;

@RestController
@RequestMapping(WebConstants.URL_APPDIRECT_CHANGE)
public class SubscriptionAppDirectChangeController extends AbstractSubscriptionController {

    @RequestMapping(method = RequestMethod.GET, headers = { WebConstants.AUTHORIZATION }, produces = MediaType.APPLICATION_XML_VALUE)
    public Result createSubscription(@RequestParam(value = WebConstants.URL, required = true) String pUrl,
                                     @RequestHeader(value = WebConstants.AUTHORIZATION) String pOauthHeader, HttpServletRequest pHttpServletRequest) {

        return processHttpRequest(pUrl, pOauthHeader, pHttpServletRequest);
    }

}
