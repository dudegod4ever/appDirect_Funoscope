package funoscope.services;

import funoscope.domain.SubscriptionDto;
import funoscope.web.context.SubscriptionParameters;

public interface SubscriptionService {
    SubscriptionDto addSubscription(SubscriptionParameters pSubscriptionParameters);

    boolean cancelSubscription(String encodedId);
}
