package com.stavre.springstarthere.mvc.service;

import com.stavre.springstarthere.mvc.model.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginService {

    private final List<User> users = List.of(
            new User("katty", "katty123"),
            new User("sam", "sam123"),
            new User("john", "john123")
    );

    public Boolean isUserValid(User user) {
        return users.contains(user);
    }
}
