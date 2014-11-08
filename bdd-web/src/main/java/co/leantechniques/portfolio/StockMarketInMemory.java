package co.leantechniques.portfolio;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StockMarketInMemory implements StockMarket {
  private Map<String, Double> storage = new HashMap<>();

  public void setCurrentPrice(String stockSymbol, double price) {
    storage.put(stockSymbol, price);
  }

  @Override
  public double getUnitPrice(String stockSymbol) {
    if(storage.containsKey(stockSymbol)) return storage.get(stockSymbol);
    return new Random().nextDouble()* (100 - 0);
  }
}
