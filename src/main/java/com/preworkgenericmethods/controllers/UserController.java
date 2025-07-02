package com.preworkgenericmethods.controllers;

import com.preworkgenericmethods.dto.UserDTO;
import com.preworkgenericmethods.models.User;
import com.preworkgenericmethods.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController extends GenericController<User, Long, UserDTO> {

    public UserController(UserService userService) {
        super(userService, User.class, UserDTO.class); // 3 parametre eklendi
    }
}
