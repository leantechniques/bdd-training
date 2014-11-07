package co.leantechniques.portfolio;

import org.joda.time.DateTime;
import org.joda.time.Period;

import static org.joda.time.DateTime.now;

public class Portfolio {
  private final Investor investor;
  private final InvestmentStrategy strategy;
  private final int rating;
  private final InvestmentStage stage;
  private final DateTime maturityDate;

  public Portfolio(Investor investor, InvestmentStrategy strategy, int rating, InvestmentStage stage, DateTime maturityDate) {
    this.investor = investor;
    this.strategy = strategy;
    this.rating = rating;
    this.stage = stage;
    this.maturityDate = maturityDate;
  }

  public Portfolio(Investor investor, InvestmentStrategy strategy, int rating, InvestmentStage stage) {
    this(investor, strategy, rating, stage, now().plus(Period.years(20)));
  }

  public Portfolio(Investor investor, InvestmentStage stage, DateTime maturityDate) {
    this(investor, InvestmentStrategy.Growth, 3, stage, maturityDate);
  }
}
