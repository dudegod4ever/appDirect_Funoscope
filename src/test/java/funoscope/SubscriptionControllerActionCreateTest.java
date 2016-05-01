package funoscope;

import static org.junit.Assert.assertNotNull;

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
public class SubscriptionControllerActionCreateTest extends AbstractSubscriptionControllerTest {

    @Test
    public void testSubscription() throws Exception {
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
        //TODO perform multiple validation on the return value
    }

    @Test
    public void testSubscriptionWrongFormat() throws Exception {
        String path = WebConstants.URL_SUBSCRIPTION_BASE
                      + WebConstants.URL_SUBSCRIPTION_CREATE.replace(WebConstants.PARAM_VERSION, VERSION_V1)
                                                            .replace(WebConstants.PARAM_COMPANY_ID, COMPANY_TEST).replace(WebConstants.PARAM_USER_ID, USER_ID);

        MvcResult refundTransactionResult = mockMvc
                                                   .perform(MockMvcRequestBuilders.post(path).accept(MediaType.APPLICATION_XML_VALUE)
                                                                                  .contentType(MediaType.APPLICATION_XML_VALUE)
                                                                                  .content(DEFAULT_SUBSCRIPTION_INVALID_STRING))
                                                   .andExpect(MockMvcResultMatchers.status().is4xxClientError()).andReturn();
        assertNotNull(refundTransactionResult);
    }
}
