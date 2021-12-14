package december.christmas.demo.dto.zorro;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Unzipped document in base64 format and the file name prefixed needed by SAP
 * {@link december.christmas.demo.service.ZorroService}
 */
@Data
@AllArgsConstructor
public class UnzippedDocAndFilePrefix {
  /**
   * Unzipped document in base64 format
   */
  private String fileInBase64;

  /**
   * Prefix of the file name needed by SAP
   */
  private String filePrefix;
}