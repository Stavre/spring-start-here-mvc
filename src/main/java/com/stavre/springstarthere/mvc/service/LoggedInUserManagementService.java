package com.stavre.springstarthere.mvc.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class LoggedInUserManagementService {
    @Getter @Setter
    private boolean loggedIn = false;
}
