package io.github.gefangshuai.server.core.context;

import io.github.gefangshuai.server.core.spring.NavigationHandlerInterceptor;
import io.github.gefangshuai.server.core.spring.WebMVCConfigurerAdapter;
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
        registry.addInterceptor(new NavigationHandlerInterceptor()).addPathPatterns("/**");
    }


}
