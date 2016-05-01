package funoscope.web.adapter;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Service;

import funoscope.util.IdGeneratorUtil;
import funoscope.web.WebConstants;
import funoscope.web.context.SubscriptionCancelParameters;
import funoscope.web.context.SubscriptionParameters;
import funoscope.web.enumeration.Frequency;
import funoscope.web.enumeration.OrderLineType;
import funoscope.web.enumeration.OrderLineUnit;
import funoscope.web.enumeration.SubscriptionStatus;
import funoscope.web.generatedxml.v1.response.Subscription;
import funoscope.web.generatedxml.v1.response.Subscription.Company;
import funoscope.web.generatedxml.v1.response.Subscription.Order;
import funoscope.web.generatedxml.v1.response.Subscription.Order.OrderLines;
import funoscope.web.generatedxml.v1.response.Subscription.Order.OrderLines.OrderLine;
import funoscope.web.generatedxml.v1.response.Subscription.Order.PaymentPlan;
import funoscope.web.generatedxml.v1.response.Subscription.Product;
import funoscope.web.generatedxml.v1.response.Subscription.User;

@Service
public class SubscriptionAdapter {

    private final static BigInteger EXTERNAL_ACCOUNT_ID = new BigInteger("1");
    private final static BigInteger PRODUCT_ID = new BigInteger("27");
    private final static BigInteger MAXUSERS = new BigInteger("1");
    private final static BigInteger ORDER_ID = new BigInteger("1");
    private final static String START_DATE = "2013-01-01";
    private final static String END_DATE = "2013-02-02";
    private final static BigInteger TOTAL_PRICE = new BigInteger("2");
    private final static BigInteger ORDELINE_PRICE = new BigInteger("2");
    private final static BigInteger ORDELINE_QUANTITY = new BigInteger("1");
    private final static String CURRENCY_USD = "USD";
    private final static String MONTHLY_FEE = "Monthly fee";

    public static final String DATE_ISO_FORMAT = "yyyy-MM-dd";
    public static final DateTimeFormatter FMT_DATE_ONLY_ISO = DateTimeFormat.forPattern(DATE_ISO_FORMAT);

    private SecureRandom random = new SecureRandom();

    public SubscriptionParameters createSubscriptionParametersFromInputParameters(String pVersion, String pCompanyId, String pUserId,
                                                                                  funoscope.web.generatedxml.v1.request.Subscription pSubscription) {
        SubscriptionParameters params = new SubscriptionParameters();
        //normally we could fecth the objects from the DB
        params.setCompanyId(pCompanyId);
        params.setUserId(pUserId);
        params.setVersion(pVersion);
        params.setGeneratedId(IdGeneratorUtil.getSubscriptionId());

        params.setSubscription(pSubscription);

        return params;
    }

    public Subscription createFreeTrialSubscriptionFromSubscriptionParameters(SubscriptionParameters pSubscriptionParameters) {
        Subscription returnSubscription = new Subscription();

        returnSubscription.setId(pSubscriptionParameters.getGeneratedId());

        Company company = new Company();
        company.setId(pSubscriptionParameters.getCompanyId());
        StringBuffer bufferCompany =
            new StringBuffer().append(WebConstants.HTTP_APPDIRECT).append(WebConstants.SLASH).append(WebConstants.ACCOUNT).append(WebConstants.SLASH)
                              .append(pSubscriptionParameters.getVersion()).append(WebConstants.SLASH).append(WebConstants.COMPANIES).append(WebConstants.SLASH)
                              .append(pSubscriptionParameters.getCompanyId());
        company.setHref(bufferCompany.toString());
        returnSubscription.setCompany(company);

        User user = new User();
        user.setId(pSubscriptionParameters.getUserId());
        StringBuffer bufferUser = new StringBuffer().append(bufferCompany.toString()).append(WebConstants.SLASH).append(WebConstants.USERS)
                                                    .append(pSubscriptionParameters.getUserId());
        user.setHref(bufferUser.toString());
        returnSubscription.setUser(user);

        returnSubscription.setStatus(SubscriptionStatus.FREE_TRIAL.name());

        returnSubscription.setExternalAccountIdentifier(EXTERNAL_ACCOUNT_ID);

        Product product = new Product();
        product.setId(PRODUCT_ID);
        StringBuffer productBuffer =
            new StringBuffer().append(WebConstants.HTTPS_APPDIRECT).append(WebConstants.SLASH).append(WebConstants.API).append(WebConstants.SLASH)
                              .append(WebConstants.MARKETPLACE).append(WebConstants.SLASH).append(WebConstants.VALID_VERSION_V1).append(WebConstants.SLASH)
                              .append(WebConstants.PRODUCTS).append(WebConstants.SLASH).append(PRODUCT_ID);
        product.setHref(productBuffer.toString());
        returnSubscription.setProduct(product);

        returnSubscription.setMaxUsers(MAXUSERS);

        Order order = new Order();
        order.setId(ORDER_ID);
        order.setStatus(SubscriptionStatus.FREE_TRIAL.name());
        order.setPaymentPlan(new PaymentPlan());
        order.setFrequency(Frequency.MONTHLY.name());

        try {
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(FMT_DATE_ONLY_ISO.parseDateTime(START_DATE).toDate());
            order.setStartDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));

            GregorianCalendar c2 = new GregorianCalendar();
            c2.setTime(FMT_DATE_ONLY_ISO.parseDateTime(END_DATE).toDate());
            order.setEndDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(c2));
        } catch (DatatypeConfigurationException ex) {
            order.setStartDate(null);
            order.setEndDate(null);
        }

        order.setTotalPrice(TOTAL_PRICE);
        order.setCurrency(CURRENCY_USD);
        order.setType(SubscriptionStatus.FREE_TRIAL.name());

        OrderLine orderLine = new OrderLine();
        orderLine.setType(OrderLineType.ITEM.name());
        orderLine.setUnit(OrderLineUnit.FLAT_RATE.name());
        orderLine.setPrice(ORDELINE_PRICE);
        orderLine.setQuantity(ORDELINE_QUANTITY);
        orderLine.setTotalPrice(TOTAL_PRICE);
        orderLine.setDescription(MONTHLY_FEE);
        OrderLines orderLines = new OrderLines();
        orderLines.setOrderLine(orderLine);
        order.setOrderLines(orderLines);

        returnSubscription.setOrder(order);

        return returnSubscription;
    }

    public SubscriptionCancelParameters createSubscriptionCancelParametersFromInputParameters(String pVersion, String pSubscriptionId) {
        SubscriptionCancelParameters params = new SubscriptionCancelParameters();

        params.setVersion(pVersion);
        params.setSubscriptionId(pSubscriptionId);

        return params;
    }

}
