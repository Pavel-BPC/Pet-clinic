package com.blinets.dependency.injection.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@Getter
//@ConstructorBinding
@ConfigurationProperties("blinets")
//@AllArgsConstructor
public class PropertiesBindingConstructorConfiguration {
    private String username;
    private String password;
    private String jdbcUrl;

    public PropertiesBindingConstructorConfiguration(String username, String password, String jdbcUrl) {
        this.username = username;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }
}
