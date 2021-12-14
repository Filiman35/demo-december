//package december.christmas.demo.repository.jdbc;
//
//import december.christmas.demo.dao.ChristmasPresent;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Slf4j
//@Repository
//public class ZorroBattleRepository {
//
//  public JdbcTemplate jdbcTemplate;
//  private Connection connection;
//
//  @Autowired
//  public ZorroBattleRepository(JdbcTemplate jdbcTemplate) throws SQLException {
//    this.jdbcTemplate = jdbcTemplate;
//  }
//
//  public void updateHero(String heroName, String heroSurname, Long heroId) {
//    String sql = "UPDATE heroes SET first_name=? , last_name=? WHERE id=?";
//
//    try {
//
//      this.connection = this.jdbcTemplate.getDataSource().getConnection();
//
//      PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//      preparedStatement.setString(1, heroName);
//      preparedStatement.setString(2, heroSurname);
//      preparedStatement.setLong  (3, heroId);
//
//      int rowsAffected = preparedStatement.executeUpdate();
//    } catch (SQLException e) {
//      log.debug("Failed to update a hero: " + e.getMessage());
//    }
//  }
//
//  public List<ChristmasPresent> getPresents(String description) {
//    List<ChristmasPresent> presents = new ArrayList<>();
//
//    try (Connection connection = this.jdbcTemplate.getDataSource().getConnection();
//         PreparedStatement preparedStatement = createPreparedStatement(connection, description);
//         ResultSet resultSet = preparedStatement.executeQuery()
//         ) {
//
//      while(resultSet.next()) {
//        presents.add(ChristmasPresent.builder()
//                .id(resultSet.getLong("id"))
//                .description(resultSet.getString("description"))
//                .build());
//      }
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//    return presents;
//  }
//
//  private PreparedStatement createPreparedStatement(Connection connection, String description) throws SQLException {
//    String sql = "SELECT id, description FROM christmas_presents WHERE id = ?";
//    PreparedStatement preparedStatement = connection.prepareStatement(sql);
//    preparedStatement.setString(1, description);
//    return preparedStatement;
//  }
//
//
//}
