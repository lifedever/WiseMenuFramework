package io.github.gefangshuai;

import io.github.gefangshuai.server.core.context.AppConfigContext;
import io.github.gefangshuai.server.core.context.MenusContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableConfigurationProperties({AppConfigContext.class, MenusContext.class})
public class WiseMenuApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WiseMenuApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.sources(applicationClass);
        return application;
    }

    private static Class<WiseMenuApplication> applicationClass = WiseMenuApplication.class;
}
