package funoscope;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public abstract class AbstractSubscriptionControllerTest {

    protected final String BASE_URL = "http://localhost:8080/";
    protected MockMvc mockMvc;

    protected final static String VERSION_V1 = "v1";
    protected final static String COMPANY_TEST = "d15bb36e-5fb5-11e0-8c3c-00262d2cda03";
    protected final static String USER_ID = "a11a7918-bb43-4429-a256-f6d729c71033";
    protected final static String SUBCRIPTION_ID = "ba2a7918-bb43-4429-a256-f6d729c71033";

    protected String DEFAULT_SUBSCRIPTION_STRING = "<subscription><order><paymentPlanId>2</paymentPlanId></order></subscription>";
    protected String DEFAULT_SUBSCRIPTION_INVALID_STRING = "<subscription><order><wrong>1</wrong></order></subscription>";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
}
