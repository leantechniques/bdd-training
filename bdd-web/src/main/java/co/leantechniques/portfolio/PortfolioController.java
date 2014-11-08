package co.leantechniques.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class PortfolioController {

  private StockMarket stockMarket;
  private PortfolioRepository repository;

  @Autowired
  public PortfolioController(StockMarket stockMarket, PortfolioRepository repository) {
    this.stockMarket = stockMarket;
    this.repository = repository;
  }

  public void purchaseDollarAmount(Principal principal, String stockSymbol, double price) {
    double unitPrice = stockMarket.getUnitPrice(stockSymbol);
    int wholeShares = (int) (price / unitPrice);
    repository.save(principal.getName(), new Holding(stockSymbol, wholeShares, unitPrice));
  }

  @RequestMapping(value="/portfolio", method=POST)
  public String purchaseShares(Principal principal, @RequestParam String stock, @RequestParam int shares){
    repository.save(principal.getName(), new Holding(stock, shares, stockMarket.getUnitPrice(stock)));
    return "redirect:/portfolio";
  }

  @RequestMapping(value="/portfolio", method=GET)
  public ModelAndView list(Principal principal){
    ModelAndView modelAndView = new ModelAndView("portfolio/list");
    modelAndView.addObject("portfolioList", repository.getAll(principal.getName()));
    return modelAndView;
  }

  public Holding getHolding(Principal principal, String stockSymbol) {
    return repository.getHolding(principal.getName(), stockSymbol);
  }
}
