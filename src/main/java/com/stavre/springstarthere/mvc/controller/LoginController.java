package com.stavre.springstarthere.mvc.controller;

import com.stavre.springstarthere.mvc.model.User;
import com.stavre.springstarthere.mvc.service.LoggedInUserManagementService;
import com.stavre.springstarthere.mvc.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final LoginService loginService;
    private final LoggedInUserManagementService loggedInUserManagementService;

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(name = "message", required = false) String message,
                               Model model) {
        model.addAttribute("message", message);
        return "login.html";
    }

    @PostMapping("/login")
    public String authenticateUser(User user) {
        if (loginService.isUserValid(user)) {
            loggedInUserManagementService.setLoggedIn(true);
            return "redirect:products";
        }

        loggedInUserManagementService.setLoggedIn(false);
        return "redirect:login?message=Auth failed";
    }
}
