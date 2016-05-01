package funoscope.web.context;

import funoscope.web.generatedxml.v1.request.Subscription;

public class SubscriptionParameters {

    private String generatedId;
    private String version;
    private String companyId;
    private String userId;
    private Subscription subscription;

    public SubscriptionParameters() {
    }

    public String getGeneratedId() {
        return generatedId;
    }

    public void setGeneratedId(String pGeneratedId) {
        generatedId = pGeneratedId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String pVersion) {
        version = pVersion;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String pCompanyId) {
        companyId = pCompanyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription pSubscription) {
        subscription = pSubscription;
    }

}
