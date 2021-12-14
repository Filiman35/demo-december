package december.christmas.demo.dto.zorro;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ZorroRequestDTO {

  /** A horse name for Zorro */
  String horse;

  /** A gun for Zorro */
  String gun;
}
