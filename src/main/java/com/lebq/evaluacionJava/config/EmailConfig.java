package com.lebq.evaluacionJava.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class EmailConfig {

    @Value("${email.regex}")
    private String emailRegex;
}
