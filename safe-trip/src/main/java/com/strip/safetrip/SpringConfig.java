package com.strip.safetrip;

import com.strip.safetrip.repository.JpaTravelRepository;
import com.strip.safetrip.repository.TravelRepository;
import com.strip.safetrip.service.TravelService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em;
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public TravelService travelService() {
        return new TravelService(travelRepository());
    }
    @Bean
    public TravelRepository travelRepository() {
        return new JpaTravelRepository(em);
    }
}
