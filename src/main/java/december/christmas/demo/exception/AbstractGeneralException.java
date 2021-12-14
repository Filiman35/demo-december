package december.christmas.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class AbstractGeneralException extends RuntimeException {

  @Setter
  private String sessionId;
  private final int code;

  /**
   * Constructor
   *
   * @param sessionId ID of session
   * @param code      standard error code
   * @param message   custom error message
   */
  public AbstractGeneralException(String sessionId, int code, String message) {
    super(message);
    this.sessionId = sessionId;
    this.code = code;
  }

  /**
   * Returns error producer system
   *
   * @return error producer system
   */
  public abstract ErrorSourceType getType();
}
