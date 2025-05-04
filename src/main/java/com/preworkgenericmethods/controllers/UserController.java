package com.preworkgenericmethods.controllers;

import com.preworkgenericmethods.models.User;
import com.preworkgenericmethods.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController extends GenericController<User, Long> {

    private final UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }
}
