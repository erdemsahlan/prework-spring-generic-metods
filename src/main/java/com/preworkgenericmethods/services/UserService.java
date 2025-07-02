package com.preworkgenericmethods.services;

import com.preworkgenericmethods.dto.UserDTO;
import com.preworkgenericmethods.models.User;

public interface UserService extends GenericService<User, Long, UserDTO> {
    User findByEmail(String email);
}
