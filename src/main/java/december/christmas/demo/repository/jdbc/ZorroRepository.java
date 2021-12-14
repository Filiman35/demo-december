//package december.christmas.demo.repository.jdbc;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.*;
//
//
//@Slf4j
//@Repository
//public class ZorroRepository {
//
//  public JdbcTemplate jdbcTemplate;
//
//  @Autowired
//  public ZorroRepository(JdbcTemplate jdbcTemplate) {
//    this.jdbcTemplate = jdbcTemplate;
//  }
//
//  /**
//   * Create request to OracleDB to get document by its GUID
//   *
//   * @param containerId SAP container ID
//   * @param docType     type of the document that we are trying to sign
//   * @param guid        GUID of the document
//   * @return document in base64 encoding and file name prefix for SAP.
//   */
//  public byte[] getBlobDocument(String containerId, String docType, String guid) {
//
//    String sql = "SELECT SAP.f_get_file_from_docs_tmp_usdo(?) FROM dual";
//    Connection connection = null;
//    PreparedStatement preparedStatement = null;
//    ResultSet resultSet = null;
//    try {
//
//      connection = this.jdbcTemplate.getDataSource().getConnection();
//      preparedStatement = connection.prepareStatement(sql);
//
//      preparedStatement.setString(1, guid);
//      log.debug("getBlobDocument: GUID param is set");
//      resultSet = preparedStatement.executeQuery();
//      log.debug("getBlobDocument: query executed");
//
//      if (resultSet != null) {
//        resultSet.next();
//        Blob zippedFileAsBlob = resultSet.getBlob(1);
//        int blobLength = (int) zippedFileAsBlob.length();
//        byte[] compressed = zippedFileAsBlob.getBytes(1, blobLength);
//        zippedFileAsBlob.free();
//        return compressed;
//      } else {
//        throw new SQLException("Result set came as null in getBlobDocument.");
//      }
//    } catch (SQLException e) {
//      log.debug("Exception while getting doc from Oracle. " + e);
//      return null;
//    } finally {
//      try {
//        if (resultSet != null) {
//          resultSet.close();
//        }
//        if (preparedStatement != null) {
//          preparedStatement.close();
//        }
//        if (connection != null) {
//          connection.close();
//        }
//      } catch (SQLException e) {
//        log.debug("Exception while closing connection resources - resultSet, " +
//            "preparedStatement or connection after executing a query. " + e);
//        return null;
//      }
//    }
//  }
//}
