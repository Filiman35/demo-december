package december.christmas.demo.exception;

/**
 * Demo exception
 */
public class BassException extends AbstractGeneralException {
  private static final long serialVersionUID = 6231320040528039265L;

  /**
   * Constructor
   *
   * @param sessionId   ID of the session
   * @param code        standard error code
   * @param description custom error message
   */
  public BassException(String sessionId, int code, String description) {
    super(sessionId, code, description);
  }

  @Override
  public ErrorSourceType getType() {
    return ErrorSourceType.BASS;
  }
}