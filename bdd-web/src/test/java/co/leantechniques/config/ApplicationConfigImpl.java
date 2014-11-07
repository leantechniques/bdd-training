package co.leantechniques.config;

import co.leantechniques.portfolio.InMemoryStockMarket;
import co.leantechniques.portfolio.StockMarket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class ApplicationConfigImpl implements BeanConfig{

  @Override
  @Bean
  public StockMarket stockMarket() {
    return new InMemoryStockMarket();
  }
}
