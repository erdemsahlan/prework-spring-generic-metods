package com.preworkgenericmethods.repositories;

import com.preworkgenericmethods.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GenericRepository<User, Long> {
    User findByEmail(String email);
}
