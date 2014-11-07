package co.leantechniques.portfolio;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStockMarket implements StockMarket {
  private Map<String, Double> storage = new HashMap<>();

  public void setCurretPrice(String stockSymbol, double price) {
    storage.put(stockSymbol, price);
  }

  @Override
  public double getUnitPrice(String stockSymbol) {
    return storage.get(stockSymbol);
  }
}
