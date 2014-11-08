package co.leantechniques.portfolio;

import java.util.Collection;

public interface PortfolioRepository {
  Collection<Holding> getAll(String account);

  Holding getHolding(String account, String stockSymbol);

  Holding save(String account, Holding value);
}
