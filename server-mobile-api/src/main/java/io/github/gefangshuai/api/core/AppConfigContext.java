package io.github.gefangshuai.api.core;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app",locations = "classpath:app.properties")
public class AppConfigContext {
    private String storePath;
    private int rtatFoodspageSize;

    public String getStorePath() {
        return storePath;
    }

    public void setStorePath(String storePath) {
        this.storePath = storePath;
    }

    public int getRtatFoodspageSize() {
        return rtatFoodspageSize;
    }

    public void setRtatFoodspageSize(int rtatFoodspageSize) {
        this.rtatFoodspageSize = rtatFoodspageSize;
    }
}