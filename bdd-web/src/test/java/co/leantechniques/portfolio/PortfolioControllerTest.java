package co.leantechniques.portfolio;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioControllerTest {

  @Mock
  private StockMarket stockMarket;

  @Mock
  private PortfolioRepository repository;

  @InjectMocks
  private PortfolioController portfolioController;

  private Principal principal = new FakePrincipal();
  private HoldingBuilder holdingBuilder = new HoldingBuilder();

  @Before
  public void setup() {
    when(stockMarket.getUnitPrice(anyString())).thenReturn(11.11);
  }

  @Test
  public void purchaseAmount(){
    portfolioController.purchaseShares("PFG", 1);

    Holding holding = portfolioController.getHolding("PFG");
    assertThat(holding.getStockSymbol(), is("PFG"));
    assertThat(holding.getUnits(), is(1));
    assertThat(holding.getValue(), is(11.11));
  }

  @Test
  public void purchaseTotal(){
    portfolioController.purchaseDollarAmount("PFG", 100);

    Holding holding = portfolioController.getHolding("PFG");
    assertThat(holding.getStockSymbol(), is("PFG"));
    assertThat(holding.getUnits(), is(9));
    assertThat(holding.getValue(), is(11.11));
  }

  @Test
  public void listPortfolioItems(){
    when(repository.getAll(principal.getName())).thenReturn(Arrays.asList(
            holdingBuilder.withSymbol("PFG").build(),
            holdingBuilder.withSymbol("GOOG").withPrice(945.23).build(),
            holdingBuilder.build()));

    ModelAndView modelAndView = portfolioController.list(principal);

    assertThat(modelAndView.getViewName(), is("portfolio/list"));
    assertThat((List<Holding>)modelAndView.getModel().get("portfolioList"), hasSize(3));
  }

}