package co.leantechniques.feature;

import co.leantechniques.config.WebAppConfigurationAware;
import co.leantechniques.portfolio.Holding;
import co.leantechniques.portfolio.InMemoryStockMarket;
import co.leantechniques.portfolio.PortfolioController;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StockPortfolioSteps extends WebAppConfigurationAware {

  private InMemoryStockMarket inMemoryStockMarket = new InMemoryStockMarket();

  PortfolioController portfolioController = new PortfolioController(inMemoryStockMarket);

  @Given("^\"(.*)\" costs \\$(.*)$")
  public void setCurrentStockPrice(String stockSymbol, double price) throws Throwable {
      inMemoryStockMarket.setCurretPrice(stockSymbol, price);
  }

  @When("^I purchase \\$(.*) of \"(.*)\" stock$")
  public void purchaseDollarAmountOfStock(double price, String stockSymbol) throws Throwable {
    portfolioController.purchaseDollarAmount(stockSymbol, price);
  }

  @When("^I purchase (.*) shares of \"(.*)\"$")
  public void purchaseNumberOfSharesOfStock(int shares, String stockSymbol) throws Throwable {
    portfolioController.purchaseShares(stockSymbol, shares);
  }

  @Then("^I own (.*) shares of \"(.*)\" for \\$(.*)$")
  public void thenIOwnSharesOfStockAtPrice(int expectedNumberOfShares, String stockSymbol, double price) throws Throwable {
    Holding holding = portfolioController.getHolding(stockSymbol);
    assertThat(holding.getUnits(), is(expectedNumberOfShares));
    assertThat(holding.getStockSymbol(), is(stockSymbol));
    assertThat(holding.getTotal(), closeTo(price, .0001));
  }
}