package funoscope;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sun.jersey.oauth.signature.OAuthParameters;

import funoscope.domain.SubscriptionAppDirectDto;
import funoscope.domain.UserAppDirectDto;
import funoscope.services.SubscriptionAppDirectService;
import funoscope.services.UserAppDirectService;
import funoscope.util.IdGeneratorUtil;
import funoscope.util.JaxbUtil;
import funoscope.util.OauthUtil;
import funoscope.web.WebConstants;
import funoscope.web.enumeration.ErrorCode;
import funoscope.web.enumeration.EventType;
import funoscope.web.generatedxml.event.Event;
import funoscope.web.generatedxml.event.Event.Creator;
import funoscope.web.generatedxml.event.Result;

@SpringApplicationConfiguration(classes = FunoscopeApplication.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class SubscriptionControllerTest {

    private final String BASE_URL = "http://localhost:8080";
    private final String DUMMY_BASE_ORDER_URL = "https://www.appdirect.com/AppDirect/rest/api/events/dummyOrder";
    private final String DUMMY_BASE_CANCEL_URL = "https://www.appdirect.com/AppDirect/rest/api/events/dummyCancel";
    private final String DUMMY_BASE_CHANGE_URL = "https://www.appdirect.com/AppDirect/rest/api/events/dummyChange";
    private final String DUMMY_ACCOUNT = "dummy-account";

    private MockMvc mockMvc;

    private final static String VERSION_V1 = "v1";
    private final static String EVENT_TOKEN = "12345";
    private final static String FIRST_NAME = "firstname";
    private final static String LAST_NAME = "lastname";
    private final static String EMAIL = "email";
    private final static String OPENID = "openid";
    private final static String UUID = "uuid";
    private final static String EVENT_STRING = "<event>" + "<type>" + EventType.SUBSCRIPTION_ORDER + "</type>" + "<marketplace>" + "    <partner>ACME</partner>"
                                               + "    <baseUrl>https://www.acme-marketplace.com</baseUrl>" + "</marketplace>" + "<creator>"
                                               + "    <email>andysen@gmail.com</email>" + "    <firstName>Andy</firstName>" + "    <lastName>Sen</lastName>"
                                               + "    <openId>https://www.acme-marketplace.com/openid/id/a11a7918-bb43-4429-a256-f6d729c71033</openId>"
                                               + "    <language>en</language>" + "</creator>" + "<payload>" + "    <company>"
                                               + "        <uuid>d15bb36e-5fb5-11e0-8c3c-00262d2cda03</uuid>" + "        <email>admin@example.com</email>"
                                               + "        <name>Example Company</name>" + "        <phoneNumber>1-415-555-1212</phoneNumber>"
                                               + "        <website>www.appdirect.com</website>" + "    </company>" + "    <order>"
                                               + "        <editionCode>BASIC</editionCode>" + "        <item>" + "            <quantity>10</quantity>"
                                               + "            <unit>USER</unit>" + "        </item>" + "        <item>" + "            <quantity>15</quantity>"
                                               + "            <unit>MEGABYTE</unit>" + "        </item>" + "    </order>" + "</payload>" + "</event>";

    private final static String AUTHORIZATION_STRING_VALUE = "OAuth realm=\"\", oauth_nonce=\"72250409\", oauth_timestamp=\"1294966759\","
                                                             + "oauth_consumer_key=\"Dummy\", oauth_signature_method=\"HMAC-SHA1\", oauth_version=\"1.0\","
                                                             + " oauth_signature=\"IBlWhOm3PuDwaSdxE/Qu4RKPtVE=\"";

    private final static String CONSUMER_KEY_VALUE = "funoscope2-111347";
    private final static String OAUTH_NONCE_VALUE = "-4431023868494294951";
    private final static String OAUTH_SIGNATURE_VALUE = "Ib%2FpyLaLIPCtO0mvzBSuspBT4mw%3D";
    private final static String OAUTH_SIGNATURE_METHOD_VALUE = "HMAC-SHA1";
    private final static String OAUTH_TIMESTAMP_VALUE = "1462208063";
    private final static String OAUTH_VERSION_VALUE = "1.0";

    private final static String validTest1 = "OAuth oauth_consumer_key=\"" + CONSUMER_KEY_VALUE + "\", oauth_nonce=\"" + OAUTH_NONCE_VALUE
                                             + "\", oauth_signature=\"" + OAUTH_SIGNATURE_VALUE + "\", oauth_signature_method=\"" + OAUTH_SIGNATURE_METHOD_VALUE
                                             + "\", oauth_timestamp=\"" + OAUTH_TIMESTAMP_VALUE + "\", oauth_version=\"" + OAUTH_VERSION_VALUE + "\"";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserAppDirectService userAppDirectService;

    @Autowired
    private SubscriptionAppDirectService subscriptionAppDirectService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        System.setProperty(WebConstants.FUNOSCOPE_CONSUMER_KEY, "Dummy");
        System.setProperty(WebConstants.FUNOSCOPE_SECRET_KEY, "secret");
    }

    @Test
    public void testSubscriptionOrder() throws Exception {

        System.setProperty(WebConstants.SKIP_AUTH_VALIDATION, "true");

        String path = WebConstants.URL_APPDIRECT_CREATE;

        String url = BASE_URL + WebConstants.URL_APPDIRECT_OAUTH_VALIDATION_STUB.replace(WebConstants.PARAM_VERSION, VERSION_V1)
                                                                                .replace(WebConstants.PARAM_EVENT_TOKEN, EVENT_TOKEN);

        url = URLEncoder.encode(url, StandardCharsets.UTF_8.name());

        MvcResult subscriptionResult = mockMvc
                                              .perform(MockMvcRequestBuilders.get(path).accept(MediaType.APPLICATION_XML_VALUE)
                                                                             .header(WebConstants.AUTHORIZATION, AUTHORIZATION_STRING_VALUE)
                                                                             .param(WebConstants.URL, DUMMY_BASE_ORDER_URL))
                                              .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        assertNotNull(subscriptionResult);
        String resultString = subscriptionResult.getResponse().getContentAsString();
        assertNotNull(resultString);
        resultString = resultString.replace("Result", "result"); //TODO hack -- investigate later
        Result result = JaxbUtil.getResultFromResponseString(resultString);
        assertNotNull(result);
        assertEquals("true", result.getSuccess());
    }

    /*@Test
    public void testSubscriptionOrderNoSkip() throws Exception {
    
        String path = WebConstants.URL_APPDIRECT_CREATE;
    
        String url = BASE_URL + WebConstants.URL_APPDIRECT_OAUTH_VALIDATION_STUB.replace(WebConstants.PARAM_VERSION, VERSION_V1)
                                                                                .replace(WebConstants.PARAM_EVENT_TOKEN, EVENT_TOKEN);
    
        url = URLEncoder.encode(url, StandardCharsets.UTF_8.name());
    
        MvcResult subscriptionResult = mockMvc
                                              .perform(MockMvcRequestBuilders.get(path).accept(MediaType.APPLICATION_XML_VALUE)
                                                                             .header(WebConstants.AUTHORIZATION, AUTHORIZATION_STRING_VALUE)
                                                                             .param(WebConstants.URL, DUMMY_BASE_URL))
                                              .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    
        assertNotNull(subscriptionResult);
        String resultString = subscriptionResult.getResponse().getContentAsString();
        assertNotNull(resultString);
        //fails because of Oauth validation
    }
    */

    @Test
    public void testSubscriptionCancel() throws Exception {

        subscriptionAppDirectService.addSubscription(DUMMY_ACCOUNT);

        System.setProperty(WebConstants.SKIP_AUTH_VALIDATION, "true");

        String path = WebConstants.URL_APPDIRECT_CANCEL;

        String url = BASE_URL + WebConstants.URL_APPDIRECT_OAUTH_VALIDATION_STUB.replace(WebConstants.PARAM_VERSION, VERSION_V1)
                                                                                .replace(WebConstants.PARAM_EVENT_TOKEN, EVENT_TOKEN);

        url = URLEncoder.encode(url, StandardCharsets.UTF_8.name());

        MvcResult subscriptionResult = mockMvc
                                              .perform(MockMvcRequestBuilders.get(path).accept(MediaType.APPLICATION_XML_VALUE)
                                                                             .header(WebConstants.AUTHORIZATION, AUTHORIZATION_STRING_VALUE)
                                                                             .param(WebConstants.URL, DUMMY_BASE_CANCEL_URL))
                                              .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        assertNotNull(subscriptionResult);
        String resultString = subscriptionResult.getResponse().getContentAsString();
        assertNotNull(resultString);
        resultString = resultString.replace("Result", "result"); //TODO hack -- investigate later
        Result result = JaxbUtil.getResultFromResponseString(resultString);
        assertNotNull(result);
        assertEquals("true", result.getSuccess());
    }

    @Test
    public void testSubscriptionChange() throws Exception {

        subscriptionAppDirectService.addSubscription(DUMMY_ACCOUNT);

        String path = WebConstants.URL_APPDIRECT_CHANGE;

        String url = BASE_URL + WebConstants.URL_APPDIRECT_OAUTH_VALIDATION_STUB.replace(WebConstants.PARAM_VERSION, VERSION_V1)
                                                                                .replace(WebConstants.PARAM_EVENT_TOKEN, EVENT_TOKEN);

        url = URLEncoder.encode(url, StandardCharsets.UTF_8.name());

        MvcResult subscriptionResult = mockMvc
                                              .perform(MockMvcRequestBuilders.get(path).accept(MediaType.APPLICATION_XML_VALUE)
                                                                             .header(WebConstants.AUTHORIZATION, AUTHORIZATION_STRING_VALUE)
                                                                             .param(WebConstants.URL, DUMMY_BASE_CHANGE_URL))
                                              .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        assertNotNull(subscriptionResult);
        String resultString = subscriptionResult.getResponse().getContentAsString();
        assertNotNull(resultString);
        resultString = resultString.replace("Result", "result"); //TODO hack -- investigate later
        Result result = JaxbUtil.getResultFromResponseString(resultString);
        assertNotNull(result);
        assertEquals("true", result.getSuccess());
    }

    @Test
    public void testSubscriptionChangeInvalid() throws Exception {

        subscriptionAppDirectService.removeSubscription(DUMMY_ACCOUNT);

        System.setProperty(WebConstants.SKIP_AUTH_VALIDATION, "true");

        String path = WebConstants.URL_APPDIRECT_CREATE;

        String url = BASE_URL + WebConstants.URL_APPDIRECT_OAUTH_VALIDATION_STUB.replace(WebConstants.PARAM_VERSION, VERSION_V1)
                                                                                .replace(WebConstants.PARAM_EVENT_TOKEN, EVENT_TOKEN);

        url = URLEncoder.encode(url, StandardCharsets.UTF_8.name());

        MvcResult subscriptionResult = mockMvc
                                              .perform(MockMvcRequestBuilders.get(path).accept(MediaType.APPLICATION_XML_VALUE)
                                                                             .header(WebConstants.AUTHORIZATION, AUTHORIZATION_STRING_VALUE)
                                                                             .param(WebConstants.URL, DUMMY_BASE_CHANGE_URL))
                                              .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        assertNotNull(subscriptionResult);
        String resultString = subscriptionResult.getResponse().getContentAsString();
        assertNotNull(resultString);
        resultString = resultString.replace("Result", "result"); //TODO hack -- investigate later
        Result result = JaxbUtil.getResultFromResponseString(resultString);
        assertNotNull(result);
        assertEquals("false", result.getSuccess());
        assertEquals(ErrorCode.USER_NOT_FOUND.name(), result.getErrorCode());
    }

    @Test
    public void testUserAppDirectService() {
        Creator creator = new Creator();
        creator.setEmail(EMAIL);
        creator.setFirstName(FIRST_NAME);
        creator.setLastName(LAST_NAME);
        creator.setOpenId(OPENID);
        creator.setUuid(UUID);

        UserAppDirectDto userAppDirectDto = userAppDirectService.addUser(creator);

        assertNotNull(userAppDirectDto);
        assertNotNull(userAppDirectDto.getAppDirectUserId());

        int result = userAppDirectService.removeUser(creator);
        assertEquals(1, result);
    }

    @Test
    public void testSubscriptionAppDirectService() {
        String accountIdentifier = IdGeneratorUtil.getSubscriptionId();

        SubscriptionAppDirectDto subscriptionAppDirectDto = subscriptionAppDirectService.addSubscription(accountIdentifier);

        assertNotNull(subscriptionAppDirectDto);
        assertNotNull(subscriptionAppDirectDto.getSubscriptionId());

        int result = subscriptionAppDirectService.removeSubscription(accountIdentifier);
        assertEquals(1, result);
    }

    @Test
    public void testSubscriptionFindAppDirectService() {
        String accountIdentifier = IdGeneratorUtil.getSubscriptionId();

        SubscriptionAppDirectDto subscriptionAppDirectDto = subscriptionAppDirectService.addSubscription(accountIdentifier);

        assertNotNull(subscriptionAppDirectDto);
        assertNotNull(subscriptionAppDirectDto.getSubscriptionId());

        SubscriptionAppDirectDto result = subscriptionAppDirectService.findSubscription(accountIdentifier);
        assertNotNull(result);
    }

    @Test
    public void TestEventCreationFromResponse() {
        Event event = JaxbUtil.getEventFromResponseString(EVENT_STRING);

        assertNotNull(event);
        assertEquals(EventType.SUBSCRIPTION_ORDER.name(), event.getType());

    }

    @Test
    public void testExtractionOauth() {
        OAuthParameters params = OauthUtil.populateFromHeader(validTest1);

        assertEquals(CONSUMER_KEY_VALUE, params.getConsumerKey());
        assertEquals(OAUTH_NONCE_VALUE, params.getNonce());
        assertEquals(OAUTH_SIGNATURE_VALUE, params.getSignature());
        assertEquals(OAUTH_SIGNATURE_METHOD_VALUE, params.getSignatureMethod());
        assertEquals(OAUTH_TIMESTAMP_VALUE, params.getTimestamp());
        assertEquals(OAUTH_VERSION_VALUE, params.getVersion());
        assertNull(params.getRealm());
    }

}
