package funoscope.web.controller;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import funoscope.domain.SubscriptionAppDirectDto;
import funoscope.domain.UserAppDirectDto;
import funoscope.services.SubscriptionAppDirectService;
import funoscope.services.UserAppDirectService;
import funoscope.util.IdGeneratorUtil;
import funoscope.util.JaxbUtil;
import funoscope.util.OauthUtil;
import funoscope.web.WebConstants;
import funoscope.web.enumeration.ErrorCode;
import funoscope.web.enumeration.EventType;
import funoscope.web.generatedxml.event.Event;
import funoscope.web.generatedxml.event.Result;

public abstract class AbstractSubscriptionController {
    @Autowired
    protected UserAppDirectService userAppDirectService;

    @Autowired
    protected SubscriptionAppDirectService subscriptionAppDirectService;

    @Autowired
    protected funoscope.http.HttpClient httpClient;

    protected Result processHttpRequest(String pUrl, String pOauthHeader, HttpServletRequest pHttpServletRequest) {
        Result result = null;

        System.out.println("OAuth Header: " + pOauthHeader);

        Event event = null;
        try {
            event = fetchEvent(pUrl, pOauthHeader, pHttpServletRequest);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Problem with url :  " + pUrl + ". Exception generated " + ex.getMessage());
            result = new Result();
            result.setSuccess(Boolean.FALSE.toString());
            result.setErrorCode(ErrorCode.CONFIGURATION_ERROR.name());
        }

        if (event != null) {
            result = dispatchEventAndReturnResult(event);
        } else if (result == null) {
            result = new Result();
            result.setSuccess(Boolean.FALSE.toString());
            result.setErrorCode(ErrorCode.UNKNOWN_ERROR.name());
        }

        return result;
    }

    protected Event fetchEvent(String pUrl, String pOauthHeader, HttpServletRequest pServletRequest) throws Exception {
        Event event = null;
        String urlToCall = URLDecoder.decode(pUrl, StandardCharsets.UTF_8.name());
        if (OauthUtil.isValid(urlToCall, WebConstants.FUNOSCOPE_CONSUMER_KEY_VALUE, WebConstants.FUNOSCOPE_SECRET_KEY_VALUE, pOauthHeader, pServletRequest)) {

            String signUrl = OauthUtil.signUrl(urlToCall, WebConstants.FUNOSCOPE_CONSUMER_KEY_VALUE, WebConstants.FUNOSCOPE_SECRET_KEY_VALUE);
            String response = httpClient.sendRequest(signUrl);
            System.out.println("Response received from server" + response);
            event = JaxbUtil.getEventFromResponseString(response);
        }

        return event;
    }

    protected Result dispatchEventAndReturnResult(Event pEvent) {
        Result result = new Result();
        if (pEvent.getType().equals(EventType.SUBSCRIPTION_ORDER)) {

            UserAppDirectDto userAppDirectDto = userAppDirectService.addUser(pEvent.getCreator());
            if (userAppDirectDto.getAppDirectUserId() != null) {
                String accountIdentifier = IdGeneratorUtil.getSubscriptionId();
                SubscriptionAppDirectDto subscriptionAppDirectDto = subscriptionAppDirectService.addSubscription(accountIdentifier);
                if (subscriptionAppDirectDto.getSubscriptionId() != null) {
                    result.setSuccess(Boolean.TRUE.toString());
                    result.setMessage(StringUtils.EMPTY);
                    result.setAccountIdentifier(accountIdentifier);
                } else {
                    result.setSuccess(Boolean.FALSE.toString());
                    result.setErrorCode(ErrorCode.UNKNOWN_ERROR.name());
                }
            }

        } else if (pEvent.getType().equals(EventType.SUBSCRIPTION_CANCEL)) {

            int success = subscriptionAppDirectService.removeSubscription(pEvent.getPayload().getAccount().getAccountIdentifier());

            if (success == 1) {
                result.setSuccess(Boolean.TRUE.toString());
                result.setMessage(StringUtils.EMPTY);
                result.setAccountIdentifier(StringUtils.EMPTY);
            } else {
                result.setSuccess(Boolean.FALSE.toString());
                result.setErrorCode(ErrorCode.USER_NOT_FOUND.name());
            }
        } else if (pEvent.getType().equals(EventType.SUBSCRIPTION_CHANGE)) {

            String accountIdentifier = pEvent.getPayload().getAccount().getAccountIdentifier();
            SubscriptionAppDirectDto subscriptionAppDirectDto = subscriptionAppDirectService.findSubscription(accountIdentifier);
            if (subscriptionAppDirectDto != null) {
                //TODO saving of the modified subscription
                result.setSuccess(Boolean.TRUE.toString());
            } else {
                result.setSuccess(Boolean.FALSE.toString());
                result.setErrorCode(ErrorCode.USER_NOT_FOUND.name());
            }

        }

        return result;
    }
}
