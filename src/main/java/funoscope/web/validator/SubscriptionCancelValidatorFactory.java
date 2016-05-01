package funoscope.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import funoscope.web.WebConstants;
import funoscope.web.context.SubscriptionCancelParameters;
import funoscope.web.validator.v1.SubscriptionCancelValidatorV1;

@Component
public class SubscriptionCancelValidatorFactory {

    private final static String ERROR_MESSAGE = "Invalid Version when Cancelling Subscription : ";

    @Autowired
    private SubscriptionCancelValidatorV1 subscriptionCancelValidatorV1;

    public SubscriptionValidator<SubscriptionCancelParameters> getSubscriptionValidator(SubscriptionCancelParameters subscriptionCancelParameters) {
        if (subscriptionCancelParameters.getVersion().toLowerCase().equals(WebConstants.VALID_VERSION_V1)) {
            return subscriptionCancelValidatorV1;
        }

        throw new IllegalStateException(ERROR_MESSAGE + subscriptionCancelParameters.getVersion());
    }
}
