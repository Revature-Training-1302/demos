package com.revature.config;

import com.revature.entity.Berry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// class-level annotation
@Configuration
public class BerryConfig {
    // method-level annotation:
    @Bean
    public Berry returnBerry() {
        return new Berry("Oran", "Heal 10 HP");
    }

}
