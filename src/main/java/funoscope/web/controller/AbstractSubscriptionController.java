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

        System.out.println("processHttpRequest OAuth Header: " + pOauthHeader);

        Event event = null;
        try {
            System.out.println("fetchEventcall");
            event = fetchEvent(pUrl, pOauthHeader, pHttpServletRequest);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Problem with url :  " + pUrl + ". Exception generated " + ex.getMessage());
            result = new Result();
            result.setSuccess(Boolean.FALSE.toString());
            result.setErrorCode(ErrorCode.CONFIGURATION_ERROR.name());
        }

        System.out.println("EVENT done " + event);

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
        System.out.println("URL ENCODE URL" + pUrl);
        String urlToCall = URLDecoder.decode(pUrl, StandardCharsets.UTF_8.name());
        System.out.println("URL DECODED URL" + urlToCall);

        String funoscopeConsumeKeyValue = System.getProperty(WebConstants.FUNOSCOPE_CONSUMER_KEY);
        String funoscopeSecretValue = System.getProperty(WebConstants.FUNOSCOPE_SECRET_KEY);

        if (OauthUtil.isValid(urlToCall, funoscopeConsumeKeyValue, funoscopeSecretValue, pOauthHeader, pServletRequest)) {

            System.out.println("SIGNING URL");

            String signUrl = OauthUtil.signUrl(urlToCall, funoscopeConsumeKeyValue, funoscopeSecretValue);
            System.out.println("SENDING REQUEST to signUrl " + signUrl);
            String response = httpClient.sendRequest(signUrl);
            System.out.println("Response received from server " + response);
            event = JaxbUtil.getEventFromResponseString(response);

            System.out.println("EVENT CReated " + response);
        }
        System.out.println("RETURNING EVENT");
        return event;
    }

    protected Result dispatchEventAndReturnResult(Event pEvent) {
        Result result = new Result();
        System.out.println("dispatchEventAndReturnResult " + pEvent.getType());
        if (pEvent.getType().equals(EventType.SUBSCRIPTION_ORDER.name())) {
            System.out.println("dispatchEventAndReturnResult ORDER");

            UserAppDirectDto userAppDirectDto = userAppDirectService.addUser(pEvent.getCreator());

            System.out.println("dispatchEventAndReturnResult userAppDirectDto ");
            if (userAppDirectDto.getAppDirectUserId() != null) {
                System.out.println("dispatchEventAndReturnResult userAppDirectDto " + userAppDirectDto);
                String accountIdentifier = IdGeneratorUtil.getSubscriptionId();

                System.out.println("dispatchEventAndReturnResult accountIdentifier " + accountIdentifier);

                SubscriptionAppDirectDto subscriptionAppDirectDto = subscriptionAppDirectService.addSubscription(accountIdentifier);
                System.out.println("dispatchEventAndReturnResult subscriptionAppDirectDto " + subscriptionAppDirectDto.getSubscriptionId());

                if (subscriptionAppDirectDto.getSubscriptionId() != null) {
                    result.setSuccess(Boolean.TRUE.toString());
                    result.setMessage(StringUtils.EMPTY);
                    result.setAccountIdentifier(accountIdentifier);
                } else {
                    result.setSuccess(Boolean.FALSE.toString());
                    result.setErrorCode(ErrorCode.UNKNOWN_ERROR.name());
                }
                System.out.println("dispatchEventAndReturnResult end ");
            }

        } else if (pEvent.getType().equals(EventType.SUBSCRIPTION_CANCEL.name())) {
            System.out.println("dispatchEventAndReturnResult CANCEL " + pEvent.getPayload().getAccount().getAccountIdentifier());
            int success = subscriptionAppDirectService.removeSubscription(pEvent.getPayload().getAccount().getAccountIdentifier());
            System.out.println("dispatchEventAndReturnResult CANCEL success " + success);

            if (success == 1) {
                result.setSuccess(Boolean.TRUE.toString());
                result.setMessage(StringUtils.EMPTY);
                result.setAccountIdentifier(pEvent.getPayload().getAccount().getAccountIdentifier());
            } else {
                result.setSuccess(Boolean.FALSE.toString());
                result.setErrorCode(ErrorCode.USER_NOT_FOUND.name());
            }
        } else if (pEvent.getType().equals(EventType.SUBSCRIPTION_CHANGE.name())) {
            System.out.println("dispatchEventAndReturnResult CHANGE");

            String accountIdentifier = pEvent.getPayload().getAccount().getAccountIdentifier();
            System.out.println("dispatchEventAndReturnResult CHANGE accountIdentifier" + accountIdentifier);
            SubscriptionAppDirectDto subscriptionAppDirectDto = subscriptionAppDirectService.findSubscription(accountIdentifier);
            if (subscriptionAppDirectDto != null) {
                //TODO saving of the modified subscription
                result.setSuccess(Boolean.TRUE.toString());
            } else {
                result.setSuccess(Boolean.FALSE.toString());
                result.setErrorCode(ErrorCode.USER_NOT_FOUND.name());
            }

            System.out.println("dispatchEventAndReturnResult CHANGE accountIdentifier" + accountIdentifier);

        }

        return result;
    }
}
