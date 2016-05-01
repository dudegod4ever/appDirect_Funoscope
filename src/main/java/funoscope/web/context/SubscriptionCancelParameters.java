package funoscope.web.context;

public class SubscriptionCancelParameters {

    private String version;
    private String subscriptionId;

    public SubscriptionCancelParameters() {
    }

    public String getVersion() {
        return version;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String pSubscriptionId) {
        subscriptionId = pSubscriptionId;
    }

    public void setVersion(String pVersion) {
        version = pVersion;
    }

}
