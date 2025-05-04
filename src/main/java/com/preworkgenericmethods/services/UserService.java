package com.preworkgenericmethods.services;

import com.preworkgenericmethods.models.User;

public interface UserService extends GenericService<User, Long> {
    User findByEmail(String email);
}
