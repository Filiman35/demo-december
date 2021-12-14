package december.christmas.demo.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/** Configuration for December Christmas Demo */
@Configuration
public class RestTemplateConfig {

  @Bean
  //@Profile("default")
  public RestTemplate restTemplateReadTimeout(RestTemplateBuilder builder) {
    return builder.setReadTimeout(Duration.ofSeconds(20)).build();
  }
}
