package december.christmas.demo.dto.spiderman;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpidermanResponseDTO {

  String newsFromSpiderman;

  String cobwebType;
}
