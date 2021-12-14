package december.christmas.demo.service;


import december.christmas.demo.dto.zorro.UnzippedDocAndFilePrefix;
//import december.christmas.demo.repository.jdbc.ZorroBattleRepository;
//import december.christmas.demo.repository.jdbc.ZorroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FilenameUtils;

@Slf4j
@Service
public class ZorroService {

//  private final ZorroRepository zorroRepository;
//  private final ZorroBattleRepository zorroBattleRepository;


//  @Autowired
//  public ZorroService(ZorroRepository zorroRepository, ZorroBattleRepository zorroBattleRepository) {
//    this.zorroRepository = zorroRepository;
//    this.zorroBattleRepository = zorroBattleRepository;
//  }


  /**
   * Create request to OracleDB to get document by its GUID
   *
   * @param containerId SAP container ID
   * @param guid        GUID of the document
   * @param docType     type of signature that should be created
   * @return document in base64 encoding and file name prefix for SAP.
   */
  public UnzippedDocAndFilePrefix getOneDocumentFromDb(String guid, String containerId, String docType) {
    String base64Result = "";
    String fileNamePrefix = "";
    byte[] compressed = "Some".getBytes();
        //zorroRepository.getBlobDocument(containerId, docType, guid);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ZipEntry zipEntry;
    byte[] buffer = new byte[1024];
    int length = 0;

    try (
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(compressed);
        ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream)) {
      while ((zipEntry = zipInputStream.getNextEntry()) != null) {
        String fileName = zipEntry.getName();
        log.debug("FILE NAME IS: =[{}]", fileName);
        if (fileName.toLowerCase().endsWith(".xml")) {
          Pattern pattern = Pattern.compile("^([^_]*_[^_]*)(?=_)");
          Matcher matcher = pattern.matcher(fileName);
          if (matcher.find()) {
            fileNamePrefix = matcher.group();
            log.debug("FILE NAME PREFIX IS: fileNamePrefix=[{}]", fileNamePrefix);
          }
          fileNamePrefix = FilenameUtils.removeExtension(fileName);
          while ((length = zipInputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
          }
        }
        String stringUtf8 = new String(outputStream.toByteArray(), Charset.forName("UTF-8"));
        log.debug("DOCUMENT IN UTF-8 ENCODING =[{}]", stringUtf8);

        base64Result = java.util.Base64.getEncoder().encodeToString(outputStream.toByteArray());

        zipInputStream.closeEntry();
      }
      outputStream.close();
    } catch (IOException e) {
      throw new RuntimeException("Failed to unzip content", e);
    }
    return new UnzippedDocAndFilePrefix(base64Result, fileNamePrefix);
  }

  public String updateHero() {
    //zorroBattleRepository.updateHero("John", "Batman", 333L);

    return "Successfully updated a hero";
  }
}