package info.thecodinglive.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("application.properties")
public class MariaDBConnectionConfig {
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String dbusername;
    @Value("${spring.datasource.password}")
    private String dbpassword;
    @Value("${spring.datasource.classname}")
    private String dbclassname;

    @Lazy
    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        final HikariConfig hikariConfig  =  new HikariConfig();
        hikariConfig.setUsername(dbusername);
        hikariConfig.setPassword(dbpassword);

        hikariConfig.addDataSourceProperty("url",dbUrl);
        hikariConfig.setDataSourceClassName(dbclassname);
        hikariConfig.setLeakDetectionThreshold(2000);
        hikariConfig.setPoolName("maruDBpool");

        final HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }

}
