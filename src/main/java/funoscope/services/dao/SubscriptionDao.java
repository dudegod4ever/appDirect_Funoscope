package funoscope.services.dao;

import funoscope.domain.SubscriptionDto;

public interface SubscriptionDao {
    SubscriptionDto addSubscription(SubscriptionDto pSubscriptionDto);

    int cancelSubscription(String encodedId);

}
