package com.sakinramazan.userservice.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@RequiredArgsConstructor
@Component
public class InterceptorsConfig implements WebMvcConfigurer {
    // we can implement any interceptor and register here
    // Now just no interceptor
}
