package co.leantechniques.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class PortfolioController {

  private StockMarket stockMarket;
  private Map<String, Holding> holdings = new HashMap<>();

  @Autowired
  public PortfolioController(StockMarket stockMarket) {
    this.stockMarket = stockMarket;
  }

  public void purchaseDollarAmount(String stockSymbol, double price) {
    double unitPrice = stockMarket.getUnitPrice(stockSymbol);
    int wholeShares = (int) (price / unitPrice);
    holdings.put(stockSymbol, new Holding(stockSymbol, wholeShares, unitPrice));
  }

  @RequestMapping(value="/portfolio/{stockSymbol}", method= POST)
  public String purchaseShares(String stockSymbol, @RequestParam int shares){
    holdings.put(stockSymbol, new Holding(stockSymbol, shares, stockMarket.getUnitPrice(stockSymbol)));
    return "portfolio/list";
  }


  public Holding getHolding(String stockSymbol) {
    return holdings.get(stockSymbol);
  }
}
