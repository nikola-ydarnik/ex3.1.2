package com.ex.ex312.util;

import com.ex.ex312.model.User;
import com.ex.ex312.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Util {

    private final UserService userService;

    @Autowired
    public Util(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        userService.addUser(new User("Nick", "Tikhonov", 27));
        userService.addUser(new User("Mari", "Tikhonova", 26));
        userService.addUser(new User("Igor", "Ratev", 34));
    }
}
