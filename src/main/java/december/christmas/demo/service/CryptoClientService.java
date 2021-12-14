//package december.christmas.demo.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.*;
//import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.StringUtils;
//import org.springframework.web.client.HttpClientErrorException;
//import org.springframework.web.client.ResourceAccessException;
//import org.springframework.web.client.RestTemplate;
//import ru.x5.signtradeedo.client.CryptoClient;
//import ru.x5.signtradeedo.dto.crypto.*;
//import ru.x5.signtradeedo.dto.general.HashAndFilePrefix;
//import ru.x5.signtradeedo.exception.SignTradeEdoException;
//
//import java.text.MessageFormat;
//import java.util.*;
//
//@Slf4j
//@Service
//public class CryptoClientService {
//
//
//     NB
//  @Autowired
//  @Qualifier("restTemplateReadTimeout")
//  private final RestTemplate restTemplate;
//
//  private final CryptoClient cryptoClient;
//
//  private final SapService sapService;
//
//  @Autowired
//  public CryptoClientService(RestTemplate restTemplate, CryptoClient cryptoClient, SapService sapService) {
//    this.restTemplate = restTemplate;
//    this.cryptoClient = cryptoClient;
//    this.sapService = sapService;
//  }
//
//  /**
//   * Default certificate sign type
//   */
//  private static final String CERTIFICATE_SIGN_TYPE = "CADES_XLT1_DETACHED";
//  private static final String DOCUMENT_GUID_UNKNOWN = "unknown";
//
//
//  @Value("${crypto.domain}")
//  private String cryptoDomain;
//
//
//  /**
//   * Get hashing algorithm from Crypto
//   *
//   * @param jwt           KeyCloak JWT token
//   * @param certificateId ID of the user certificate issued by CryptoPro DSS
//   * @param containerId   SAP container id
//   * @param docType       type of signature that should be created
//   * @return response from Crypto that contains ID of certificate and list of hashing algorithms or (optionally)
//   * message about the error
//   */
//  public HashAlgorithmResponseDTO getHashAlgorithmDto(String jwt, String certificateId, String containerId, String docType) {
//    // to get list of hash algorithms we must use /certificates/{certificateId} controller of Crypto:
//    log.debug("getHashAlgorithm(certificateId=[{}])", certificateId);
//    log.debug("getHashAlgorithm(jwt=[{}])", jwt);
//    String theUrl = MessageFormat.format("{0}/certificates/{1}", cryptoDomain, certificateId);
//    HttpHeaders headers = new HttpHeaders();
//    headers.set("Authorization", "Bearer " + jwt);
//    HttpEntity<String> request = new HttpEntity<>(headers);
//    log.debug("CryptoClientService.getHashAlgorithmDto (url=[{}])", theUrl);
//
//    HashAlgorithmResponseDTO emptyBody = HashAlgorithmResponseDTO.builder()
//        .certificateId(certificateId)
//        .hashAlgorithmList(new ArrayList<>())
//        .build();
//
//    ResponseEntity<HashAlgorithmResponseDTO> response = new ResponseEntity<>(emptyBody, HttpStatus.NOT_FOUND);
//    try {
//      response = restTemplate.exchange(theUrl, HttpMethod.GET, request, HashAlgorithmResponseDTO.class);
//      if (response == null) {
//        log.debug("Null response from Crypto when trying to get hash algorithm (responseStatusCode=[{}])", response.getStatusCode());
//        sapService.sendErrorToSap(containerId, docType, 21, DOCUMENT_GUID_UNKNOWN);
//        throw new SignTradeEdoException(containerId,
//            "Null response from Crypto when trying to get hash algorithm (responseStatusCode= " + response.getStatusCode() + ")");
//      }
//      if (response.getStatusCode() != HttpStatus.OK) {
//        log.debug("Response from Crypto when trying to get hash algorithm (responseStatusCode=[{}]) came with error", response.getStatusCode());
//        sapService.sendErrorToSap(containerId, docType, 21, DOCUMENT_GUID_UNKNOWN);
//        throw new SignTradeEdoException(containerId,
//            "Response with error from Crypto when trying to get hash algorithm (responseStatusCode= " + response.getStatusCode() + ")");
//      }
//      return response.getBody();
//    } catch (RuntimeException exception) {
//      log.debug("Caught RuntimeException while getting hashing algorithm from Crypto");
//      sapService.sendErrorToSap(containerId, docType, 21, DOCUMENT_GUID_UNKNOWN);
//      return response.getBody();
//    }
//  }
//
//  /**
//   * Extracts hashing algorithm from response DTO and checks if there are any errors
//   *
//   * @param containerId SAP container id
//   * @param responseDTO response DTO from Crypto, contains hash algorithm, error (if there were any) and certificate ID
//   * @param docType     type of signature that should be created
//   * @return hashing algorithm as a string
//   */
//  public String getHashAlgorithm(String containerId, HashAlgorithmResponseDTO responseDTO, String docType) {
//    if (StringUtils.hasText(responseDTO.getError())) {
//      sapService.sendErrorToSap(containerId, docType, 21, DOCUMENT_GUID_UNKNOWN);
//      String errorMessage = responseDTO.getError() + "for container with ID: " + containerId;
//      log.debug("Error while getting hashing algorithm = {}", errorMessage);
//      throw new SignTradeEdoException(containerId, "Error Getting hashing algorithm = (" + errorMessage + ")");
//    }
//    if (CollectionUtils.isEmpty(responseDTO.getHashAlgorithmList())) {
//      log.debug("Hash algorithm returned for container with ID " + containerId + " is null or empty");
//      sapService.sendErrorToSap(containerId, docType, 20, DOCUMENT_GUID_UNKNOWN);
//      throw new SignTradeEdoException(containerId, "Hash algorithm returned for container ID  is null or empty");
//    } else {
//      return responseDTO.getHashAlgorithmList().get(0);
//    }
//  }
//
//  /**
//   * Get one hash of the document from MS Crypto
//   *
//   * @param jwt             KeyCloak JWT token
//   * @param documentsToHash list of documents to be hashed (contains GUID of the doc, hashing algorithm and file
//   *                        content in Base64 encoding
//   * @return response with signature or error
//   */
//
//  public List<OneHashedDocResponseDTO> getDocumentHashes(
//      String jwt,
//      List<OneHashedDocRequestDTO> documentsToHash) {
//    return cryptoClient.getHashedDocuments(jwt, documentsToHash);
//  }
//
//  /**
//   * Check response with one hashed document for errors
//   *
//   * @param hashedDocuments response with hashes of documents
//   * @param containerId     ID of the SAP container
//   * @param docType         type of signature that should be created
//   * @param guid            GUID of the document
//   */
//  public void checkHashedDocsForErrors(List<OneHashedDocResponseDTO> hashedDocuments, String containerId, String docType, String guid) {
//    hashedDocuments.forEach(hashedDoc -> {
//      if (StringUtils.hasText(hashedDoc.getError())) {
//        String errorMessage = hashedDoc.getError() + "for doc with GUID: " + hashedDoc.getId();
//        log.debug("Error getting document hash - errorMessage " + errorMessage + "[containerId] = {}", containerId);
//        sapService.sendErrorToSap(containerId, docType, 50, guid);
////                throw new CryptoException(containerId, 500, errorMessage);
//      } else if (StringUtils.isEmpty(hashedDoc.getHashedContent())) {
//        log.debug("hash of document with GUID " + hashedDoc.getId() + " is null or empty [containerId] = {}", containerId);
//        sapService.sendErrorToSap(containerId, docType, 50, guid);
////                throw new SignSapFuelException(containerId, errorMessage);
//      } else if (StringUtils.isEmpty(hashedDoc.getId())) {
//        log.debug("One hash of document came from Crypto with null or empty GUID [containerId] = {}", containerId);
//        sapService.sendErrorToSap(containerId, docType, 148, guid);
////                throw new SignSapFuelException(
//      }
//    });
//  }
//
//  /**
//   * Create request to MS Crypto to sign document
//   *
//   * @param hashAlgorithm algorithm of hashing
//   * @param certificateId certificate id
//   * @param hashesOfDocs  map that contains GUIDs as keys and hashes of documents as values in Base64 encoding
//   * @param jwt           KeyCloak JWT token
//   * @param containerId   SAP container id
//   * @return response with signature or error
//   */
//  public List<SignPackageResponseDTO> getSignatureCrypto(
//      String hashAlgorithm,
//      String certificateId,
//      Map<String, HashAndFilePrefix> hashesOfDocs,
//      String jwt,
//      String containerId) {
//
//    Set<OneDocToSign> docsToSign = new HashSet<>();
//    for (Map.Entry<String, HashAndFilePrefix> entry : hashesOfDocs.entrySet()) {
//      String guid = entry.getKey();
//      HashAndFilePrefix hashOfOneDoc = entry.getValue();
//      OneDocToSign oneDocToSign = OneDocToSign.builder()
//          .id(guid)
//          .docHash(hashOfOneDoc.getHash())
//          .build();
//      docsToSign.add(oneDocToSign);
//    }
//    SignDocumentRequestDTO signDocumentRequestDTO = SignDocumentRequestDTO.builder()
//        .certificateId(certificateId)
//        .certificateHashAlg(hashAlgorithm)
//        .signType(CERTIFICATE_SIGN_TYPE)
//        .docHashList(docsToSign).build();
//
//    log.debug("getSignatureCrypto(certificateId=[{}], containerId=[{}])", certificateId, containerId);
//    log.debug("getSignatureCrypto(signDocumentRequestDTO=[{}]", signDocumentRequestDTO);
//    return cryptoClient.signDocument(jwt, signDocumentRequestDTO);
//  }
//
//  /**
//   * Check response with list of signatures from Crypto
//   *
//   * @param signatureDTOs response with the list of signatures
//   * @param containerId   ID of the SAP container
//   */
//  public void checkSignaturePackage(List<SignPackageResponseDTO> signatureDTOs, String containerId, String docType) {
//    String firstDocumentGuid = signatureDTOs.get(0).getId();
//    if (CollectionUtils.isEmpty(signatureDTOs)) {
//      log.debug("The response is null when tried to get package of signatures. containerId=[{}])", containerId);
//      sapService.sendErrorToSap(containerId, docType, 51, firstDocumentGuid);
//      //            throw new SignSapFuelException(
////            containerId, ErrorSourceType.MS_CRYPTO + ": The response is empty  or null when tried to get package of signatures.")
//    } else {
//      for (SignPackageResponseDTO signatureDTO : signatureDTOs) {
//        if (signatureDTO == null) {
//          log.debug("The response is null when tried to get package of signatures. containerId=[{}])", containerId);
//          sapService.sendErrorToSap(containerId, docType, 51, firstDocumentGuid);
////                    throw new SignSapFuelException(
////                    containerId, ErrorSourceType.MS_CRYPTO + ": One signature was null in response in the package of signatures.")
//        }
//        if (signatureDTO != null && StringUtils.hasText(signatureDTO.getError())) {
//          log.debug("Errors when signing in MS Crypto. containerId=[{}])", containerId);
//          sapService.sendErrorToSap(containerId, docType, 51, firstDocumentGuid);
//        }
//        if (signatureDTO != null && !StringUtils.hasText(signatureDTO.getSignature())) {
//          log.debug("The signature is null or empty in the package of signatures.. containerId=[{}])", containerId);
//          sapService.sendErrorToSap(containerId, docType, 147, firstDocumentGuid);
////                    throw new SignSapFuelException(
////                    containerId, ErrorSourceType.MS_CRYPTO + ": The signature is null or empty in the package of signatures.")
//        }
//      }
//    }
//  }
//
//}