package december.christmas.demo.client;

import december.christmas.demo.dto.santa.LetterToSanta;
import december.christmas.demo.dto.santa.PresentToSanta;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/** Client for SAP */
public interface SantaClient {

  /**
   * Send letters to North Pole
   *
   * @param letter letter to Santa
   */
  @RequestLine("POST /santa/sendLetter")
  @Headers("Content-Type: application/json")
  void sendLetterToSanta(LetterToSanta letter);

  /**
   * Send a present to old Santa Claus
   *
   * @param present present to Santa
   */
  @RequestLine("POST /santa/sendPresent")
  @Headers("Content-Type: application/json")
  void sendBalanceToSap(PresentToSanta present);
}
