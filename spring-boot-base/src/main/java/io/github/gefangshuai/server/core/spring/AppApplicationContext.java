package io.github.gefangshuai.server.core.spring;

import org.springframework.context.ApplicationContext;

/**
 * Spring ApplicationContext 的载体
 * Created by gefangshuai on 2015/11/5.
 */
public class AppApplicationContext {
    private static AppApplicationContext ourInstance = new AppApplicationContext();
    private ApplicationContext applicationContext;


    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public static AppApplicationContext getInstance() {
        return ourInstance;
    }

    private AppApplicationContext() {
    }
}
