package december.christmas.demo.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** Zorro properties */
@Data
@Component
public class ZorroProperties {
  /** Domain to connect with Zorro */
  @Value("${zorro.domain}")
  private String domain;

  /** Login from Zorro API */
  @Value("${zorro.login}")
  private String login;

  /** Password from Zorro API */
  @Value("${zorro.password}")
  private String password;
}
