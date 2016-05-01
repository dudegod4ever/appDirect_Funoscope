package funoscope.domain;

public class SubscriptionDto {

    private Integer id;
    private Integer paymentPlanId;
    private String encodedId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer pId) {
        id = pId;
    }

    public Integer getPaymentPlanId() {
        return paymentPlanId;
    }

    public void setPaymentPlanId(Integer pPaymentPlanId) {
        paymentPlanId = pPaymentPlanId;
    }

    public String getEncodedId() {
        return encodedId;
    }

    public void setEncodedId(String pEncodedId) {
        encodedId = pEncodedId;
    }

}
