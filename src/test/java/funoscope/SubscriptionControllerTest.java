package funoscope;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import funoscope.web.WebConstants;

@SpringApplicationConfiguration(classes = FunoscopeApplication.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class SubscriptionControllerTest extends AbstractSubscriptionControllerTest {

    private final static String RESPONSE_STARTSWITH = "<Subscription><id>";

    @Test
    public void testSubscriptionCreateCancel() throws Exception {
        String path = WebConstants.URL_SUBSCRIPTION_BASE
                      + WebConstants.URL_SUBSCRIPTION_CREATE.replace(WebConstants.PARAM_VERSION, VERSION_V1)
                                                            .replace(WebConstants.PARAM_COMPANY_ID, COMPANY_TEST).replace(WebConstants.PARAM_USER_ID, USER_ID);

        MvcResult subscriptionResult = mockMvc
                                              .perform(MockMvcRequestBuilders.post(path).accept(MediaType.APPLICATION_XML_VALUE)
                                                                             .contentType(MediaType.APPLICATION_XML_VALUE).content(DEFAULT_SUBSCRIPTION_STRING))
                                              .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();
        assertNotNull(subscriptionResult);
        String resultString = subscriptionResult.getResponse().getContentAsString();
        assertNotNull(resultString);
        assertTrue(resultString.startsWith(RESPONSE_STARTSWITH));

        /*TODO there<S a bug with the unmarshalling, getting Subscription instead of subscription
         JAXBContext jc = JAXBContext.newInstance(Subscription.class);
        InputStream stream = new ByteArrayInputStream(resultString.getBytes(StandardCharsets.UTF_8));
        Subscription subscription = (Subscription) jc.createUnmarshaller().unmarshal(stream);
         String subscriptionId = subscription.getId();*/

        String subscriptionId = resultString.substring(RESPONSE_STARTSWITH.length(), RESPONSE_STARTSWITH.length() + 36);

        String cancelPath =
            WebConstants.URL_SUBSCRIPTION_BASE + WebConstants.URL_SUBSCRIPTION_CANCEL.replace(WebConstants.PARAM_VERSION, VERSION_V1)
                                                                                     .replace(WebConstants.PARAM_SUBSCRIPTION_ID, subscriptionId);

        MvcResult subscriptionCancelResult = mockMvc.perform(MockMvcRequestBuilders.delete(cancelPath).content(DEFAULT_SUBSCRIPTION_STRING))
                                                    .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        assertNotNull(subscriptionCancelResult);
        String resultCancelString = subscriptionCancelResult.getResponse().getContentAsString();
        assertTrue(StringUtils.isEmpty(resultCancelString));
    }

    @Test
    public void testSubscriptionCreateCancelNotFound() throws Exception {
        String path = WebConstants.URL_SUBSCRIPTION_BASE
                      + WebConstants.URL_SUBSCRIPTION_CREATE.replace(WebConstants.PARAM_VERSION, VERSION_V1)
                                                            .replace(WebConstants.PARAM_COMPANY_ID, COMPANY_TEST).replace(WebConstants.PARAM_USER_ID, USER_ID);

        MvcResult subscriptionResult = mockMvc
                                              .perform(MockMvcRequestBuilders.post(path).accept(MediaType.APPLICATION_XML_VALUE)
                                                                             .contentType(MediaType.APPLICATION_XML_VALUE).content(DEFAULT_SUBSCRIPTION_STRING))
                                              .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();
        assertNotNull(subscriptionResult);
        String resultString = subscriptionResult.getResponse().getContentAsString();
        assertNotNull(resultString);
        assertTrue(resultString.startsWith(RESPONSE_STARTSWITH));

        /*TODO there<S a bug with the unmarshalling, getting Subscription instead of subscription
         JAXBContext jc = JAXBContext.newInstance(Subscription.class);
        InputStream stream = new ByteArrayInputStream(resultString.getBytes(StandardCharsets.UTF_8));
        Subscription subscription = (Subscription) jc.createUnmarshaller().unmarshal(stream);
         String subscriptionId = subscription.getId();*/

        String subscriptionIdInvalid = resultString.substring(RESPONSE_STARTSWITH.length(), RESPONSE_STARTSWITH.length() + 32);

        String cancelPath =
            WebConstants.URL_SUBSCRIPTION_BASE + WebConstants.URL_SUBSCRIPTION_CANCEL.replace(WebConstants.PARAM_VERSION, VERSION_V1)
                                                                                     .replace(WebConstants.PARAM_SUBSCRIPTION_ID, subscriptionIdInvalid);

        MvcResult subscriptionCancelResult = mockMvc.perform(MockMvcRequestBuilders.delete(cancelPath).content(DEFAULT_SUBSCRIPTION_STRING))
                                                    .andExpect(MockMvcResultMatchers.status().isNotFound()).andReturn();
        assertNotNull(subscriptionCancelResult);
    }

}
