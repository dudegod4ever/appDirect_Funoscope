package funoscope.services.adapter;

import org.springframework.stereotype.Service;

import funoscope.domain.SubscriptionDto;
import funoscope.web.context.SubscriptionParameters;

@Service
public class SubscriptionDtoAdapter {

    public SubscriptionDto creatSubscriptionDtoFromSubscription(SubscriptionParameters pParams) {
        SubscriptionDto subscriptionDto = new SubscriptionDto();

        subscriptionDto.setPaymentPlanId(pParams.getSubscription().getOrder().getPaymentPlanId().intValue());
        subscriptionDto.setEncodedId(pParams.getGeneratedId());

        return subscriptionDto;
    }

}
