package io.github.gefangshuai.server.config.context;

import freemarker.cache.ClassTemplateLoader;
import io.github.gefangshuai.ext.shiro.ShiroExtConfiguration;
import io.github.gefangshuai.ext.spring.WebMVCConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

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
