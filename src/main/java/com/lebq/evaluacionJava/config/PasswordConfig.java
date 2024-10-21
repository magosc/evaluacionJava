package com.lebq.evaluacionJava.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class PasswordConfig {

    @Value("${password.regex}")
    private String passwordRegex;
}
