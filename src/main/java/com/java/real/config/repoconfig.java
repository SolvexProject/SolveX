import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.java.real.repository.jpa")
@EnableMongoRepositories(basePackages = "com.java.real.repository.mongodb")
public class RepositoriesConfig {
}