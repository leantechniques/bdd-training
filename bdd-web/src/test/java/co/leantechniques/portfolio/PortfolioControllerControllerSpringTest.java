package co.leantechniques.portfolio;

import co.leantechniques.config.WebAppConfigurationAware;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
public class PortfolioControllerControllerSpringTest extends WebAppConfigurationAware {

  @Test
  public void purchaseSharesForPortfolio() throws Exception {

    // POST porfolio/pfg?shares=3&totalAmount=45.23
    // GET porfolio - returns all the holdings
    // GET porfolio/pfg/
    // Add enw holding: POST holding {symbol, number of dollars || number of shares}
    MvcResult result = mockMvc.perform(post("/portfolio/PFG?shares=3"))
//            .andDo(print())
//            .andExpect(MockMvcResultMatchers.)
//            .andExpect(model().attribute("shares", is(3)))
            .andReturn();
    assertThat(result.getModelAndView().getViewName(), is("portfolio/list"));
    assertThat(result.getRequest().getParameter("shares"), is("3"));
    System.out.println(result.getModelAndView().getModelMap());
  }

}
