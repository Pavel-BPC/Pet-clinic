package com.blinets.dependency.injection.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties("blinets")
@Configuration
public class PropertiesBindingConfiguration {
    private String username;
    private String password;
    private String jdbcUrl;
}
