package funoscope.web;

public class WebConstants {

    public final static String HTTP_APPDIRECT = "http://www.appdirect.com";
    public final static String HTTPS_APPDIRECT = "https://www.appdirect.com";

    public final static String HTTP_FUNOSCOPE = "http://a.knrz.co/horoscope-api/archive";///2016/32/aries

    public final static String SLASH = "/";
    public final static String LEFT_BRACKET = "{";
    public final static String RIGHT_BRACKET = "}";
    public final static String API = "api";
    public final static String BILLING = "billing";
    public final static String COMPANIES = "companies";
    public final static String SUBSCRIPTIONS = "subscriptions";
    public final static String USERS = "users";
    public final static String VERSION = "version";
    public final static String COMPANY_ID = "companyId";
    public final static String USER_ID = "userId";
    public final static String SUBSCRIPTION_ID = "subscriptionId";
    public final static String ACCOUNT = "account";
    public final static String MARKETPLACE = "marketplace";
    public final static String PRODUCTS = "products";
    public final static String FUNOSCOPE = "funoscope";

    public final static String PARAM_VERSION = LEFT_BRACKET + VERSION + RIGHT_BRACKET;
    public final static String PARAM_COMPANY_ID = LEFT_BRACKET + COMPANY_ID + RIGHT_BRACKET;
    public final static String PARAM_USER_ID = LEFT_BRACKET + USER_ID + RIGHT_BRACKET;
    public final static String PARAM_SUBSCRIPTION_ID = LEFT_BRACKET + SUBSCRIPTION_ID + RIGHT_BRACKET;

    public final static String VALID_VERSION_V1 = "v1";

    public final static String URL_SUBSCRIPTION_BASE = SLASH + API + SLASH + BILLING;
    public final static String URL_SUBSCRIPTION_CREATE =
        SLASH + PARAM_VERSION + SLASH + COMPANIES + SLASH + PARAM_COMPANY_ID + SLASH + USERS + SLASH + PARAM_USER_ID;
    public final static String URL_SUBSCRIPTION_CANCEL = SLASH + PARAM_VERSION + SLASH + SUBSCRIPTIONS + SLASH + PARAM_SUBSCRIPTION_ID;

    public final static String URL_FUNOSCOPE_BASE = SLASH + FUNOSCOPE;
    public final static String URL_FUNOSCOPE_GET = SLASH + PARAM_VERSION;

}
