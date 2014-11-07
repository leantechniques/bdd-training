package co.leantechniques.config;

import co.leantechniques.portfolio.StockMarket;

public class StockMarketClient implements StockMarket {
  @Override
  public double getUnitPrice(String stockSymbol) {
    return 0;
  }
}
