package co.leantechniques.portfolio;

import co.leantechniques.config.WebSecurityConfigurationAware;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
public class PortfolioControllerControllerSpringTest extends WebSecurityConfigurationAware {

  @Test
  public void listPortfolio() throws Exception {
    MockHttpSession session = getAuthenticatedMockSession("admin", "admin");

    MvcResult result = mockMvc.perform(get("/portfolio").session(session))
            .andReturn();

    assertThat(result.getModelAndView().getViewName(), is("portfolio/list"));
  }

  @Test
  public void purchaseSharesForPortfolio() throws Exception {
    MockHttpSession session = getAuthenticatedMockSession("admin", "admin");
    MvcResult result = mockMvc.perform(post("/portfolio?stock=PFG&shares=3").session(session))
//            .andDo(print())
//            .andExpect(MockMvcResultMatchers.)
//            .andExpect(model().attribute("shares", is(3)))
            .andReturn();
//    assertThat(result.getModelAndView().getViewName(), is("portfolio/list"));
    assertThat(result.getRequest().getParameter("stock"), is("PFG"));
    assertThat(result.getRequest().getParameter("shares"), is("3"));
  }

}
