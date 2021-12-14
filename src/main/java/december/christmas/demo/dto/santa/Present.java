package december.christmas.demo.dto.santa;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Present {

  /** Name of present */
  String presentName;

  /** Description of present */
  String description;
}
