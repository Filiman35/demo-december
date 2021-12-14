package december.christmas.demo.exception.decoder;

import december.christmas.demo.exception.BassException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import december.christmas.demo.client.SantaClient;

/** Feign client error decoder for {@link SantaClient} */
@Slf4j
public class DemoErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    String sessionId = "1111aaaaa";
    int status = response.status();
    log.debug("decode: Error response with status [{}]", status);
    return new BassException(sessionId, status, response.reason() + " : " + response.request().url());
  }
}