package co.leantechniques.portfolio;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class InMemoryPortfolioRepository implements PortfolioRepository{

  private List<Holding> holdings = new ArrayList<>();

  @Override
  public Collection<Holding> getAll(String account) {
    return holdings;
  }
}
