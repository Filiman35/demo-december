package december.christmas.demo.client;

import december.christmas.demo.dto.spiderman.SpidermanRequestDTO;
import december.christmas.demo.dto.spiderman.SpidermanResponseDTO;
import feign.HeaderMap;
import feign.RequestLine;

import javax.validation.Valid;
import java.util.Map;

/** Client for Spiderman */
public interface SpidermanClient {

  /**
   * Send POST request to send message to Spiderman
   *
   * @param headers          authorization headers with API key and basic auth token
   * @param spidermanRequest message to Spiderman
   * @return answer from Spiderman
   */
  @Valid
  @RequestLine("POST /spiderman/message")
  SpidermanResponseDTO sendMessageToSpiderman(@HeaderMap Map<String, String> headers,
                                              SpidermanRequestDTO spidermanRequest);

  /**
   * Send POST request to quickly inform Spiderman about danger
   *
   * @param headers       authorization headers with API key and basic auth token
   * @param alarmRequest alarm to Spiderman
   * @return answer from Spiderman
   */
  @RequestLine("POST /spiderman/alarm")
  SpidermanResponseDTO sendAlarmToSpiderman(
      @HeaderMap Map<String, String> headers, SpidermanRequestDTO alarmRequest);
}
