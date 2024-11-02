package dev.chaitanya.runnerz.run.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RepositoryConfig {

    @Bean
    @Profile("memory")
    public IRunRepository inMemoryRunRepository() {
        return new InMemoryRunRepository();
    }

    @Bean
    @Profile("h2")
    public IRunRepository h2RunRepository() {
        return new H2RunRepository();
    }
}
