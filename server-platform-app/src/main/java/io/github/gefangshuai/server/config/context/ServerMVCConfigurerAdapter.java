package io.github.gefangshuai.server.config.context;

import io.github.gefangshuai.ext.spring.WebMVCConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * Web 有关适配器
 * Created by gefangshuai on 2015/11/11.
 */
@Configuration
public class ServerMVCConfigurerAdapter extends WebMVCConfigurerAdapter {

    @Bean
    public GlobalParamsInterceptor globalParamsInterceptor() {
        return new GlobalParamsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(globalParamsInterceptor()).addPathPatterns("/**");
    }


}
