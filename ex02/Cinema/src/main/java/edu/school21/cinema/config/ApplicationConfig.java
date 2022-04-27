package edu.school21.cinema.config;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.cinema.repositories.*;
import edu.school21.cinema.services.ImageService;
import edu.school21.cinema.services.SessionService;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@Configuration
@ComponentScan("edu.school21.cinema")
@PropertySource("classpath:../application.properties")
public class ApplicationConfig {

    @Value("${db.url}")
    private String url;

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String password;

    @Value("${db.driver.name}")
    private String driverName;

    @Value("${storage.path}")
    private String storagePath;

    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);
        ds.setDriverClassName(driverName);
        return ds;
    }

    @Bean
    public String getStoragePath() {
        return storagePath;
    }

//    @Bean
//    public DataSource dataSource() {
//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        return builder.setType(EmbeddedDatabaseType.HSQL).addScripts("users.sql", "data.sql").build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserRepositoryImpl userRepository(@Autowired DataSource ds) throws SQLException, IOException {
        return new UserRepositoryImpl(ds);
    }

    @Bean
    public SessionRepositoryImpl sessionRepository(@Autowired DataSource ds) throws SQLException, IOException {
        return new SessionRepositoryImpl(ds);
    }

    @Bean
    public ImageRepositoryImpl imageRepository(@Autowired DataSource ds) throws SQLException, IOException {
        return new ImageRepositoryImpl(ds);
    }

    @Bean
    public UserService userService(@Autowired UserRepository ur, PasswordEncoder pe) throws SQLException, IOException {
        return new UserService(ur, pe);
    }

    @Bean
    public SessionService sessionService(@Autowired SessionRepository sr) throws SQLException, IOException {
        return new SessionService(sr);
    }

    @Bean
    public ImageService imageService(@Autowired ImageRepository ir) throws SQLException, IOException {
        return new ImageService(ir);
    }
}
