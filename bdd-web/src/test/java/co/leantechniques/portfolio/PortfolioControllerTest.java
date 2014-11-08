package co.leantechniques.portfolio;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
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
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioControllerTest {

  @Mock
  private StockMarket stockMarket;
  @Mock
  private PortfolioRepository repository;

  private PortfolioController controller;

  private Principal principal = new FakePrincipal();
  private HoldingBuilder holdingBuilder = new HoldingBuilder();

  @Before
  public void setup() {
    when(stockMarket.getUnitPrice(anyString())).thenReturn(11.11);
    controller = new PortfolioController(stockMarket, repository);
  }

  @Test
  public void purchaseAmount(){
    controller.purchaseShares(principal, "PFG", 1);

    ArgumentCaptor<Holding> captor = ArgumentCaptor.forClass(Holding.class);
    verify(repository).save(anyString(), captor.capture());
    Holding actual = captor.getValue();
    assertThat(actual.getStockSymbol(), is("PFG"));
    assertThat(actual.getUnits(), is(1));
    assertThat(actual.getValue(), is(11.11));
  }

  @Test
  public void purchaseTotal(){
    controller.purchaseDollarAmount(principal, "PFG", 100);

    ArgumentCaptor<Holding> captor = ArgumentCaptor.forClass(Holding.class);
    verify(repository).save(anyString(), captor.capture());
    Holding actual = captor.getValue();
    assertThat(actual.getStockSymbol(), is("PFG"));
    assertThat(actual.getUnits(), is(9));
    assertThat(actual.getValue(), is(11.11));
  }

  @Test
  public void listPortfolioItems(){
    when(repository.getAll(principal.getName())).thenReturn(Arrays.asList(
            holdingBuilder.withSymbol("PFG").build(),
            holdingBuilder.withSymbol("GOOG").withPrice(945.23).build(),
            holdingBuilder.build()));

    ModelAndView modelAndView = controller.list(principal);

    assertThat(modelAndView.getViewName(), is("portfolio/list"));
    assertThat((List<Holding>)modelAndView.getModel().get("portfolioList"), hasSize(3));
  }
}