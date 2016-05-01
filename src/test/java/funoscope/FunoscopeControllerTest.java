package funoscope;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import funoscope.web.WebConstants;

@SpringApplicationConfiguration(classes = FunoscopeApplication.class)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class FunoscopeControllerTest {

    protected MockMvc mockMvc;

    protected final static String VERSION_V1 = "v1";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testFunoscope() throws Exception {
        String path = WebConstants.URL_FUNOSCOPE_BASE + WebConstants.SLASH + VERSION_V1;

        MvcResult funoscopeResult = mockMvc.perform(MockMvcRequestBuilders.get(path)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        assertNotNull(funoscopeResult);
        assertNotNull(funoscopeResult.getResponse().getContentAsString());
        assertTrue(StringUtils.isNotEmpty(funoscopeResult.getResponse().getContentAsString()));
    }

}
