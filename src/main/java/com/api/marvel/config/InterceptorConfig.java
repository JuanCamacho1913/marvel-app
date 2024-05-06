package com.api.marvel.config;

import com.api.marvel.controllers.interceptors.UserInteractionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    UserInteractionInterceptor userInteractionInterceptor;

    public InterceptorConfig(UserInteractionInterceptor userInteractionInterceptor) {
        this.userInteractionInterceptor = userInteractionInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.userInteractionInterceptor);
    }
}
