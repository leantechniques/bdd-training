package co.leantechniques.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class PortfolioController {

  private StockMarket stockMarket;
  private PortfolioRepository repository;
  private Map<String, Holding> holdings = new HashMap<>();

  @Autowired
  public PortfolioController(StockMarket stockMarket, PortfolioRepository repository) {
    this.stockMarket = stockMarket;
    this.repository = repository;
  }

  public void purchaseDollarAmount(String stockSymbol, double price) {
    double unitPrice = stockMarket.getUnitPrice(stockSymbol);
    int wholeShares = (int) (price / unitPrice);
    holdings.put(stockSymbol, new Holding(stockSymbol, wholeShares, unitPrice));
  }

  @RequestMapping(value="/portfolio/{stockSymbol}", method=POST)
  public String purchaseShares(String stockSymbol, @RequestParam int shares){
    holdings.put(stockSymbol, new Holding(stockSymbol, shares, stockMarket.getUnitPrice(stockSymbol)));
    return "portfolio/list";
  }

  @RequestMapping(value="/portfolio", method=GET)
  public ModelAndView list(Principal principal){
    ModelAndView modelAndView = new ModelAndView("portfolio/list");
    modelAndView.addObject("portfolioList", repository.getAll(principal.getName()));
    return modelAndView;
  }

  public Holding getHolding(String stockSymbol) {
    return holdings.get(stockSymbol);
  }
}
