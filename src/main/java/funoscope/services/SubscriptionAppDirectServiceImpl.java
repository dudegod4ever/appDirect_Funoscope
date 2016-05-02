package funoscope.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import funoscope.domain.SubscriptionAppDirectDto;
import funoscope.services.adapter.SubscriptionAppDirectAdapter;
import funoscope.services.dao.SubscriptionAppDirectDao;

@Service
public class SubscriptionAppDirectServiceImpl implements SubscriptionAppDirectService {
    @Autowired
    private SubscriptionAppDirectAdapter subscriptionAppDirectAdapter;

    @Autowired
    private SubscriptionAppDirectDao subscriptionAppDirectDao;

    @Override
    public SubscriptionAppDirectDto addSubscription(String pAccountIdentifier) {
        SubscriptionAppDirectDto userAppDirectDto = subscriptionAppDirectAdapter.createAppDirectSubscriptionFromAccountIdentifier(pAccountIdentifier);
        return subscriptionAppDirectDao.addSubscription(userAppDirectDto);
    }

    @Override
    public SubscriptionAppDirectDto findSubscription(String pAccountIdentifier) {
        return subscriptionAppDirectDao.findSubscription(pAccountIdentifier);
    }

    @Override
    public int removeSubscription(String pAccountIdentifier) {
        return subscriptionAppDirectDao.removeSubscription(pAccountIdentifier);
    }
}
