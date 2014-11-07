package co.leantechniques.portfolio;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PortfolioControllerTest {

  @Mock
  private StockMarket stockMarket;

  @InjectMocks
  private PortfolioController portfolioController;

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

}