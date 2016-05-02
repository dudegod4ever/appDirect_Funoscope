package funoscope.services.adapter;

import org.springframework.stereotype.Service;

import funoscope.domain.SubscriptionAppDirectDto;

@Service
public class SubscriptionAppDirectAdapter {

    public SubscriptionAppDirectDto createAppDirectSubscriptionFromAccountIdentifier(String pAccountIdentifier) {
        SubscriptionAppDirectDto subscriptionAppDirectDto = new SubscriptionAppDirectDto();

        subscriptionAppDirectDto.setAccountIdentifier(pAccountIdentifier);

        return subscriptionAppDirectDto;
    }
}
