package december.christmas.demo.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** Santa properties */
@Data
@Component
public class SantaProperties {

  /**
   * Basic authorization token that should be present in HTTP request headers from Santa or other
   * servers
   */
  @Value("${authorize-foreign-servers.auth-token}")
  private String basicAuthorizationToken;

  /** Domain to connect with Santa */
  @Value("${santa.domain}")
  private String domain;

  /** Login to get authorized in Sant */
  @Value("${santa.login}")
  private String login;

  /** Password to get authorized in Santa */
  @Value("${santa.password}")
  private String password;
}
