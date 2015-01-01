package co.leantechniques.version;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(value = "classpath:applicationContext-version.xml")
public class VersionConfig {
//  private String version;

//  @Bean
//  public String getVersion(){return version;}
}
