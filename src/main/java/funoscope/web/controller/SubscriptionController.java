package funoscope.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import funoscope.services.SubscriptionService;
import funoscope.web.WebConstants;
import funoscope.web.adapter.SubscriptionAdapter;
import funoscope.web.context.SubscriptionCancelParameters;
import funoscope.web.context.SubscriptionParameters;
import funoscope.web.generatedxml.v1.request.Subscription;
import funoscope.web.validator.SubscriptionCancelValidatorFactory;
import funoscope.web.validator.SubscriptionCreateValidatorFactory;
import funoscope.web.validator.SubscriptionValidator;

@RestController
@RequestMapping(WebConstants.URL_SUBSCRIPTION_BASE)
public class SubscriptionController {

    @Autowired
    private SubscriptionAdapter subscriptionAdapter;

    @Autowired
    private SubscriptionCreateValidatorFactory subscriptionCreateValidatorFactory;

    @Autowired
    private SubscriptionCancelValidatorFactory subscriptionCancelValidatorFactory;

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping(
        value = WebConstants.URL_SUBSCRIPTION_CREATE,
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_XML_VALUE,
        produces = MediaType.APPLICATION_XML_VALUE)
    public funoscope.web.generatedxml.v1.response.Subscription createSubscription(@PathVariable(WebConstants.VERSION) String pVersion,
                                                                                  @PathVariable(WebConstants.COMPANY_ID) String pCompanyId,
                                                                                  @PathVariable(WebConstants.USER_ID) String pUserId,
                                                                                  @RequestBody Subscription pSubscription, HttpServletResponse pResponse) {

        funoscope.web.generatedxml.v1.response.Subscription returnSubscription = null;
        SubscriptionParameters params = subscriptionAdapter.createSubscriptionParametersFromInputParameters(pVersion, pCompanyId, pUserId, pSubscription);
        SubscriptionValidator<SubscriptionParameters> validator = subscriptionCreateValidatorFactory.getSubscriptionValidator(params);

        if (validator.validate(params)) {
            //free trials for everyone
            returnSubscription = subscriptionAdapter.createFreeTrialSubscriptionFromSubscriptionParameters(params);
            pResponse.setStatus(HttpServletResponse.SC_CREATED);
            subscriptionService.addSubscription(params);
        } else {
            pResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        return returnSubscription;
    }

    @RequestMapping(value = WebConstants.URL_SUBSCRIPTION_CANCEL, method = RequestMethod.DELETE)
    public void cancelSubscription(@PathVariable(WebConstants.VERSION) String pVersion, @PathVariable(WebConstants.SUBSCRIPTION_ID) String pSubscriptionId,
                                   HttpServletResponse pResponse) {

        SubscriptionCancelParameters params = subscriptionAdapter.createSubscriptionCancelParametersFromInputParameters(pVersion, pSubscriptionId);
        SubscriptionValidator<SubscriptionCancelParameters> validator = subscriptionCancelValidatorFactory.getSubscriptionValidator(params);

        if (validator.validate(params)) {
            if (subscriptionService.cancelSubscription(params.getSubscriptionId())) {
                pResponse.setStatus(HttpServletResponse.SC_OK);
            } else {
                pResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            pResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
