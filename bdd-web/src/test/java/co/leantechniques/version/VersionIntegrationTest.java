package co.leantechniques.version;

import co.leantechniques.config.WebAppConfigurationAware;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringJUnit4ClassRunner.class)
public class VersionIntegrationTest extends WebAppConfigurationAware {

  public static final int GIT_HASH_LENGTH = 40;

  @Test
  public void outputsVersion() throws Exception {

    System.setProperty("buildNumber", "some-long-git-hash");

    MvcResult mvcResult = mockMvc.perform(get("/version"))
            .andReturn();
    System.out.println(mvcResult.getResponse().getContentAsString());
    assertThat(mvcResult.getResponse().getContentLength(), is(GIT_HASH_LENGTH));
  }
}
