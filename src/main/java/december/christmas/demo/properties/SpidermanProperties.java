package december.christmas.demo.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** Shell properties */
@Data
@Component
public class SpidermanProperties {

  /** Root request URI of Spiderman server */
  @Value("${spiderman.domain}")
  private String domain;

  /** Secret API key from Spiderman server */
  @Value("${spiderman.apikey}")
  private String apiKey;

  /**
   * Basic authorization token that should be present in HTTP
   * request headers when requesting Spiderman server
   */
  @Value("${spiderman.auth-token}")
  private String basicAuthorizationToken;
}
