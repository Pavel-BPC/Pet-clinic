package com.blinets.dependency.injection.datasource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeDataSource {
    private String username;
    private String password;
    private String jdbcUrl;
}
