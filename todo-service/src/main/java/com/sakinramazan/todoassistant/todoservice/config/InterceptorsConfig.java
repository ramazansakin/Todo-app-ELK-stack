package com.sakinramazan.todoassistant.todoservice.config;

import com.sakinramazan.todoassistant.todoservice.interceptor.RequestEntityCheckInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@RequiredArgsConstructor
@Component
public class InterceptorsConfig implements WebMvcConfigurer {

    private final RequestEntityCheckInterceptor responseEntityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // define the interceptor path u wanna impact on
        // here, all apis contains the path below
        registry.addInterceptor(responseEntityInterceptor).addPathPatterns("/api/todos/*");
    }

}
