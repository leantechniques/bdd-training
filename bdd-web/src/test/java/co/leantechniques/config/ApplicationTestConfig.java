package co.leantechniques.config;

import co.leantechniques.portfolio.StockMarket;
import co.leantechniques.portfolio.StockMarketInMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class ApplicationTestConfig extends ApplicationConfig {

  @Override
  @Bean
  public StockMarket stockMarket() {
    return new StockMarketInMemory();
  }
}
