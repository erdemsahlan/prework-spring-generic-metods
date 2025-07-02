package com.preworkgenericmethods.services;

import com.preworkgenericmethods.dto.UserDTO;
import com.preworkgenericmethods.models.User;
import com.preworkgenericmethods.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long, UserDTO> implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public void handleRelations(User entity, UserDTO userDTO) {
        // İlişki yönetimi buraya gelecek
        // Örnek: entity.setDepartment(departmentRepo.findById(userDTO.getDepartmentId()));
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class; // Null yerine User.class dönmeli
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
