package io.github.gefangshuai.core.context;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 对应 classpath:config/app.properties
 * Created by gefangshuai on 2015/11/10.
 */
@ConfigurationProperties(prefix = "app",locations = "classpath:config/app.properties")
public class AppConfig {
    private String storePath;

    public String getStorePath() {
        return storePath;
    }

    public void setStorePath(String storePath) {
        this.storePath = storePath;
    }
}
