package funoscope.services;

import funoscope.domain.SubscriptionAppDirectDto;

public interface SubscriptionAppDirectService {

    SubscriptionAppDirectDto addSubscription(String pAccountIdentifier);

    SubscriptionAppDirectDto findSubscription(String pAccountIdentifier);

    int removeSubscription(String pAccountIdentifier);
}
