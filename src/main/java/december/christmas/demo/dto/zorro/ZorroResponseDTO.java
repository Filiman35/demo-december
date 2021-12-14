package december.christmas.demo.dto.zorro;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ZorroResponseDTO {
  /** Message from Zorro */
  String holaFromZorro;

  /** Help from Zorro */
  String helpFromZorro;
}
