package co.leantechniques.config;

import co.leantechniques.portfolio.StockMarket;
import org.springframework.context.annotation.Bean;

public interface BeanConfig {
  @Bean
  StockMarket stockMarket();
}
