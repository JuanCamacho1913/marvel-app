package com.api.marvel.config.validator;

import com.api.marvel.services.impl.UserDetailServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class InteractionLogUser {

    private UserDetailServiceImpl userDetailService;

    public InteractionLogUser(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    public boolean validate(String username){
        return this.userDetailService.getUserLoggedIn().equals(username);
    }
}
