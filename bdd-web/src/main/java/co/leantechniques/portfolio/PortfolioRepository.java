package co.leantechniques.portfolio;

import java.util.Collection;

public interface PortfolioRepository {
  Collection<Holding> getAll(String account);
}
