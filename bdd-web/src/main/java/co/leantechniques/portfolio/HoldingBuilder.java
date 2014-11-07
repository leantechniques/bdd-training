package co.leantechniques.portfolio;

public class HoldingBuilder {
  private String symbol = "PFG";
  private int units = 123;
  private double value = 74.32;

  public HoldingBuilder withSymbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public Holding build() {

    return new Holding(symbol, units, value);
  }

  public HoldingBuilder withPrice(double value) {
    this.value = value;
    return this;
  }
}
