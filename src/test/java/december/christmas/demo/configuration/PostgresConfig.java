package december.christmas.demo.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

//@TestConfiguration
public class PostgresConfig {

//  @Value("${spring.datasource.url}")
//  private String dbUrl;
//
//  @Value("${spring.datasource.username}")
//  private String dbUsername;
//
//  @Value("${spring.datasource.password}")
//  private String dbPassword;
//
//  @Value("${spring.datasource.driver-class-name}")
//  private String dbDriverClassName;
//
//  @Bean
//  DataSource dataSource() {
//    HikariConfig hikariConfig = new HikariConfig();
//    hikariConfig.setJdbcUrl(dbUrl);
//    hikariConfig.setUsername(dbUsername);
//    hikariConfig.setPassword(dbPassword);
//    hikariConfig.setDriverClassName(dbDriverClassName);
//
//    return new HikariDataSource(hikariConfig);
//  }
}