package com.api.marvel.controllers.interceptors;

import com.api.marvel.persistence.entity.HistoryEntity;
import com.api.marvel.persistence.repositories.HistoryRepository;
import com.api.marvel.services.impl.UserDetailServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@Component
public class UserInteractionInterceptor implements HandlerInterceptor {

    HistoryRepository historyRepository;

    @Lazy
    @Autowired
    UserDetailServiceImpl userDetailService;

    public UserInteractionInterceptor(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestUri = request.getRequestURI();

        if (requestUri.startsWith("/comic") || requestUri.startsWith("/character")){
            HistoryEntity historyEntity = new HistoryEntity();

            historyEntity.setHttpMethod(request.getMethod());
            historyEntity.setUrl(request.getRequestURI().toString());

            String user = this.userDetailService.getUserLoggedIn();
            historyEntity.setUsername(user);
            historyEntity.setRemoteAddress(request.getRemoteAddr());
            historyEntity.setTimestamp(LocalDateTime.now());

            try {
                this.historyRepository.save(historyEntity);
            }catch (Exception e){
                throw new RuntimeException("Error al guardar el historico");
            }

        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
