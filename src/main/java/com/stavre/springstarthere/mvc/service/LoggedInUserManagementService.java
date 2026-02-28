package com.stavre.springstarthere.mvc.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Setter
@Getter
@Component
public class LoggedInUserManagementService {
    private boolean loggedIn = false;
    private String username;
}
