package december.christmas.demo.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Используется в unit тестах для упрощения получения данных из файлов-ресурсов. для использования
 * надо добавить статические ресурсы в виде: @<code>
 * public static Resource exportCommandDto = new ClassPathResource("/json/export/export-command-dto.json");
 * </code>
 */
@Data
@Slf4j
public abstract class AbstractTestResourcePool {
  public static final String ERROR_IO = "Ошибка при получении данных из файла-ресурса";
  private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

  protected AbstractTestResourcePool() {}

  public static <T> T read(Resource resource, Class<T> tClass) {
    try {
      return mapper.readValue(resource.getInputStream(), tClass);
    } catch (IOException e) {
      log.error(ERROR_IO, e);
      throw new SantaTestResourcePoolException(e);
    }
  }

  public static <T> T read(Resource resource, TypeReference<T> tr) {
    try {
      return mapper.readValue(resource.getInputStream(), tr);
    } catch (IOException e) {
      log.error(ERROR_IO, e);
      throw new SantaTestResourcePoolException(e);
    }
  }

  public static String getString(Resource resource) {
    try {
      return IOUtils.toString(resource.getInputStream(), Charset.defaultCharset().toString());
    } catch (IOException e) {
      log.error(ERROR_IO, e);
      throw new SantaTestResourcePoolException(e);
    }
  }

  private static class SantaTestResourcePoolException extends RuntimeException {
    public SantaTestResourcePoolException(Throwable cause) {
      super(cause);
    }
  }
}
