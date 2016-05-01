package funoscope.web.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import funoscope.web.WebConstants;
import funoscope.web.context.SubscriptionParameters;
import funoscope.web.validator.v1.SubscriptionCreateValidatorV1;

@Component
public class SubscriptionCreateValidatorFactory {

    private final static String ERROR_MESSAGE = "Invalid Version when Creating Subscription : ";

    @Autowired
    private SubscriptionCreateValidatorV1 subscriptionCreateValidatorV1;

    public SubscriptionValidator<SubscriptionParameters> getSubscriptionValidator(SubscriptionParameters subscriptionParameters) {
        if (subscriptionParameters.getVersion().toLowerCase().equals(WebConstants.VALID_VERSION_V1)) {
            return subscriptionCreateValidatorV1;
        }

        throw new IllegalStateException(ERROR_MESSAGE + subscriptionParameters.getVersion());
    }
}
