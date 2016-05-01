package funoscope.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import funoscope.domain.SubscriptionDto;
import funoscope.services.adapter.SubscriptionDtoAdapter;
import funoscope.services.dao.SubscriptionDao;
import funoscope.web.context.SubscriptionParameters;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionDao subscriptionDao;

    @Autowired
    private SubscriptionDtoAdapter subscriptionDtoAdapter;

    @Override
    public SubscriptionDto addSubscription(SubscriptionParameters pSubscriptionParameters) {
        SubscriptionDto subscriptionDto = subscriptionDtoAdapter.creatSubscriptionDtoFromSubscription(pSubscriptionParameters);
        return subscriptionDao.addSubscription(subscriptionDto);
    }

    @Override
    public boolean cancelSubscription(String pEncodedId) {
        int result = subscriptionDao.cancelSubscription(pEncodedId);
        if (result == 1) {
            return true;
        }
        return false;
    }
}
