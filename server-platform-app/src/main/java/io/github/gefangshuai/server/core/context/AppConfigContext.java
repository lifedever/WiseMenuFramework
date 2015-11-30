package io.github.gefangshuai.server.core.context;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 对应 classpath:config/app.properties
 * Created by gefangshuai on 2015/11/10.
 */
@ConfigurationProperties(prefix = "app",locations = "classpath:config/app.properties")
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
