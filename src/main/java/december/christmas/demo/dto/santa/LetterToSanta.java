package december.christmas.demo.dto.santa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Letter to Santa Used in {@link PresentToSanta}
 */
@Data
@Builder
public class LetterToSanta {
  /** Message that explains the error happened during making of letter */
  private String errorMessage;

  /** Status of the error happened during writing of the letter */
  private String errorStatusCode;

  /** Start date and time of letter */
  private String requestedDateTimeFrom;

  /** End date and time of letter */
  private String requestedDateTimeTo;

  /** List of presents I want for Christmas */
  private List<Present> presentList;
}