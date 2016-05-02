package funoscope;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

import funoscope.domain.SubscriptionAppDirectDto;
import funoscope.domain.UserAppDirectDto;
import funoscope.services.SubscriptionAppDirectService;
import funoscope.services.UserAppDirectService;
import funoscope.util.IdGeneratorUtil;
import funoscope.util.JaxbUtil;
import funoscope.web.WebConstants;
import funoscope.web.enumeration.EventType;
import funoscope.web.generatedxml.event.Event;
import funoscope.web.generatedxml.event.Event.Creator;

@SpringApplicationConfiguration(classes = FunoscopeApplication.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class SubscriptionControllerTest {

    private final String BASE_URL = "http://localhost:8080";
    private final String DUMMY_BASE_URL = "https://www.appdirect.com/AppDirect/rest/api/events/dummyChange";
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

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserAppDirectService userAppDirectService;

    @Autowired
    private SubscriptionAppDirectService subscriptionAppDirectService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testSubscriptionOrder() throws Exception {
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

    @Test
    public void testSubscriptionCancel() throws Exception {
        String path = WebConstants.URL_APPDIRECT_CANCEL;

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

    @Test
    public void testSubscriptionChange() throws Exception {
        String path = WebConstants.URL_APPDIRECT_CHANGE;

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

}
