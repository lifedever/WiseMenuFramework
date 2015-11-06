package io.github.gefangshuai;

import io.github.gefangshuai.core.spring.AppApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("io.github.gefangshuai")
public class WiseMenuApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WiseMenuApplication.class, args);
        AppApplicationContext.getInstance().setApplicationContext(ctx);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<WiseMenuApplication> applicationClass = WiseMenuApplication.class;
}
