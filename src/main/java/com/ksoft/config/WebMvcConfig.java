package com.ksoft.config;

import com.ksoft.inteceptor.BaseInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
    @Autowired
    private BaseInterceptor apiInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiInterceptor).addPathPatterns("/api/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/404").setViewName("common/404");
        registry.addViewController("/401").setViewName("common/401");
        registry.addViewController("/500").setViewName("common/500");
        registry.addViewController("/wc/grzx").setViewName("common/grzx");
        registry.addViewController("/users/pwd").setViewName("update-pwd");
        registry.addRedirectViewController("/","/index");
        registry.addRedirectViewController("/docs","/swagger-ui.html");
        super.addViewControllers(registry);
    }

}
