package co.leantechniques.portfolio;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PortfolioRepositoryInMemory implements PortfolioRepository{

  private Map<String, Holding> holdingsByStockSymbol = new HashMap<>();

  @Override
  public Collection<Holding> getAll(String account) {
    return holdingsByStockSymbol.values();
  }

  @Override
  public Holding getHolding(String account, String stockSymbol) {
    return holdingsByStockSymbol.get(stockSymbol);
  }

  @Override
  public Holding save(String account, Holding value) {
    return holdingsByStockSymbol.put(value.getStockSymbol(), value);
  }
}
