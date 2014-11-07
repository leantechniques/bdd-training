package co.leantechniques.portfolio;

public class Holding {
  private String stockSymbol = "";
  private Double value = new Double(0);
  private Integer units = new Integer(0);

  public Holding(String stockSymbol, int units, double value) {
    this.stockSymbol = stockSymbol;
    this.units = units;
    this.value = value;
  }

  public int getUnits() {
    return units;
  }

  public String getStockSymbol() {
    return stockSymbol;
  }

  public Double getValue() {
    return value;
  }

  public Double getTotal() {
    return units * value;
  }
}
