package funoscope.web.validator.v1;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import funoscope.web.context.SubscriptionParameters;
import funoscope.web.validator.SubscriptionValidator;

@Component(value = "subscriptionCreateValidatorV1")
public class SubscriptionCreateValidatorV1 implements SubscriptionValidator<SubscriptionParameters> {

    @Override
    public boolean validate(SubscriptionParameters pParams) {

        if (StringUtils.isEmpty(pParams.getCompanyId()) || StringUtils.isEmpty(pParams.getUserId()) || StringUtils.isEmpty(pParams.getVersion())) {
            return false;
        }

        if (pParams.getSubscription() == null || pParams.getSubscription().getOrder() == null
            || pParams.getSubscription().getOrder().getPaymentPlanId() == null) {
            return false;
        }

        return true;
    }

}
