package io.github.gefangshuai.server.core.spring;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import java.util.Properties;

/**
 * 定义了mvc适配器
 * Created by gefangshuai on 2015/11/3.
 */
@Configuration
public class WebMVCConfigurerAdapter extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {

    /**
     * 国际化配置
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    /**
     * 防止出现：Cannot change HTTP accept header - use a different locale resolution strategy异常
     *
     * @return
     */
    @Bean(name = "localeResolver")
    public SessionLocaleResolver sessionLocaleResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(new Locale("zh", "CN"));
        return localeResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor()).addPathPatterns("/**");
    }

    /**
     * 定义mvc错误及页面映射
     *
     * @return
     */
    @Bean(name = "errorMapping")
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();


        // 设置异常映射
        Properties properties = new Properties();
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException", "/error/403");
        properties.setProperty("org.apache.shiro.authz.UnauthenticatedException", "/error/401");
        exceptionResolver.setExceptionMappings(properties);

        exceptionResolver.setDefaultErrorView("/error/500");
        exceptionResolver.setDefaultStatusCode(500);

        return exceptionResolver;
    }


    /**
     * 配置文件上传
     *
     * @return
     */
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setDefaultEncoding("utf-8");
        multipartResolver.setMaxUploadSize(100000000);
        return multipartResolver;
    }

}
