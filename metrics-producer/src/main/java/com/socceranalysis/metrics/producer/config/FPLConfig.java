package com.socceranalysis.metrics.producer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "fpl")
@Data
public class FPLConfig {
    private String url;
}
