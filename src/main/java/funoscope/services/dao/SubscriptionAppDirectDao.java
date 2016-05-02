package funoscope.services.dao;

import funoscope.domain.SubscriptionAppDirectDto;

public interface SubscriptionAppDirectDao {
    SubscriptionAppDirectDto addSubscription(SubscriptionAppDirectDto pSubscriptionAppDirectDto);

    SubscriptionAppDirectDto findSubscription(String pAccountIdentifier);

    int removeSubscription(String pAccountIdentifier);
}
