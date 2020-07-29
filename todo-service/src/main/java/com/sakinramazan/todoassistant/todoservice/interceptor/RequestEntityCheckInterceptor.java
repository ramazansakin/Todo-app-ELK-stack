package com.sakinramazan.todoassistant.todoservice.interceptor;

import com.sakinramazan.todoassistant.todoservice.exception.NotAllowedApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class RequestEntityCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("Todo Controller preHandle");
        // we can intercept any url here
        // logging, blocking, dispatching ...
        // I wanna block updating todos
        if (request.getRequestURI().contains("/update"))
            throw new NotAllowedApiException(request.getRequestURL().toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        log.info("Todo Controller postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {
        // you can log anything here after api completion
        // log.info("Airport Controller afterCompletion");
    }
}
