package funoscope.web.validator.v1;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import funoscope.web.context.SubscriptionCancelParameters;
import funoscope.web.validator.SubscriptionValidator;

@Component(value = "subscriptionCancelValidatorV1")
public class SubscriptionCancelValidatorV1 implements SubscriptionValidator<SubscriptionCancelParameters> {

    @Override
    public boolean validate(SubscriptionCancelParameters pParams) {

        if (StringUtils.isEmpty(pParams.getVersion()) || StringUtils.isEmpty(pParams.getSubscriptionId())) {
            return false;
        }

        return true;
    }

}
