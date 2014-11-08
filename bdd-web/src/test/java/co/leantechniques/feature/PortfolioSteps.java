package co.leantechniques.feature;

import co.leantechniques.config.WebAppConfigurationAware;
import co.leantechniques.portfolio.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.security.Principal;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PortfolioSteps extends WebAppConfigurationAware {

  private StockMarketInMemory stockMarketInMemory = new StockMarketInMemory();
  private PortfolioRepositoryInMemory portfolioRepository = new PortfolioRepositoryInMemory();
  private Principal principal = new FakePrincipal();

  PortfolioController portfolioController = new PortfolioController(stockMarketInMemory, portfolioRepository);

  @Given("^\"(.*)\" costs \\$(.*)$")
  public void setCurrentStockPrice(String stockSymbol, double price) throws Throwable {
      stockMarketInMemory.setCurrentPrice(stockSymbol, price);
  }

  @When("^I purchase \\$(.*) of \"(.*)\" stock$")
  public void purchaseDollarAmountOfStock(double price, String stockSymbol) throws Throwable {
    portfolioController.purchase(principal, stockSymbol, null, price);
  }

  @When("^I purchase (.*) shares of \"(.*)\"$")
  public void purchaseNumberOfSharesOfStock(int shares, String stockSymbol) throws Throwable {
    portfolioController.purchase(principal, stockSymbol, shares, null);
  }

  @Then("^I own (.*) shares of \"(.*)\" for \\$(.*)$")
  public void thenIOwnSharesOfStockAtPrice(int expectedNumberOfShares, String stockSymbol, double price) throws Throwable {
    Holding holding = portfolioController.getHolding(principal, stockSymbol);
    assertThat(holding.getUnits(), is(expectedNumberOfShares));
    assertThat(holding.getStockSymbol(), is(stockSymbol));
    assertThat(holding.getTotal(), closeTo(price, .0001));
  }
}