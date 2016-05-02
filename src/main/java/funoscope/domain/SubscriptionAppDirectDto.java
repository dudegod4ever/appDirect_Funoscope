package funoscope.domain;

public class SubscriptionAppDirectDto {

    private Integer subscriptionId;
    private String accountIdentifier;

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer pSubscriptionId) {
        subscriptionId = pSubscriptionId;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String pAccountIdentifier) {
        accountIdentifier = pAccountIdentifier;
    }

}
