package december.christmas.demo.client.zorro;

import december.christmas.demo.dto.zorro.ZorroResponseDTO;
import feign.HeaderMap;
import feign.Param;
import feign.RequestLine;
import java.util.Map;

/** Client to call Zorro for help */
public interface ZorroCallClient {
  /**
   * Send GET request to notify Zorro that his help is needed
   *
   * @param headers   custom headers for Zorro
   * @param letter    letter to Zorro
   * @param signature signature so Zorro can trust our letter
   */
  @RequestLine("GET /zorro/message?letter={letter}&priority=high&signature={signature}")
  ZorroResponseDTO getLetterBackFromZorro(
      @HeaderMap Map<String, String> headers,
      @Param("letter") String letter,
      @Param("signature") String signature);
}
