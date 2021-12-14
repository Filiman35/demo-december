package december.christmas.demo.dto.santa;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/** Package to be delivered to Santa */
@Data
@Builder
public class PresentToSanta {

  /** Package for Santa Claus */
  private String packageToSanta;

  /** Address of Santa */
  @NotEmpty
  private String santaAddress;

  /** Error message */
  private String errorMessage;

  /** Status of the error */
  private String errorStatusCode;

  /** Santa's phone number */
  @NotEmpty private String santaPhoneNumber;

  /** Date and time of sending */
  @NotEmpty private String startOfSendingDateTime;
}
