package december.christmas.demo.client.zorro;

import december.christmas.demo.dto.zorro.ZorroResponseDTO;
import feign.HeaderMap;
import feign.Param;
import feign.RequestLine;

import javax.validation.Valid;
import java.util.Map;

/** Client to send emergency leters to Zorro */
public interface ZorroEmergencyClient {
  /**
   * Send GET request to get Zorro current situation
   *
   * @param headers       custom headers
   * @param place         place where we need Zorro
   * @param enemiesNumber number of soldiers that wait Zorro
   * @param startDateTime start time of battle
   * @param endDateTime   end time of battle
   *
   * @return answer from Zorro
   */
  @Valid
  @RequestLine("GET /zorro/emergency?place={place}&priority=emergency&enemies={enemiesNumber}&begin={startDateTime}&end={endDateTime}")
  ZorroResponseDTO getIntouchWithZorro(
      @HeaderMap Map<String, String> headers,
      @Param("place") String place,
      @Param("enemiesNumber") String enemiesNumber,
      @Param("startDateTime") String startDateTime,
      @Param("endDateTime") String endDateTime);
}
