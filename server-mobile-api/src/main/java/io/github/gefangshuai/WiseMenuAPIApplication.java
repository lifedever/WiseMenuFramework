package io.github.gefangshuai;

import io.github.gefangshuai.api.core.AppConfigContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@EnableConfigurationProperties({AppConfigContext.class})
public class WiseMenuAPIApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WiseMenuAPIApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.sources(applicationClass);
        return application;
    }

    private static Class<WiseMenuAPIApplication> applicationClass = WiseMenuAPIApplication.class;
}
