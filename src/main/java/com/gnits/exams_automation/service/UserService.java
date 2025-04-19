package com.gnits.exams_automation.service;


import com.gnits.exams_automation.entity.User;
import com.gnits.exams_automation.mapper.UserMapper;
import com.gnits.exams_automation.dto.UserDTO;
import com.gnits.exams_automation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO user) {
        if (user.getId() != null && (userRepository.existsById(user.getId()) || userRepository.existsByEmail(user.getEmail()))) {
            throw new RuntimeException("User already exists");
        }
        return UserMapper.toDTO(userRepository.save(UserMapper.toEntity(user)));
    }

    public UserDTO updateUser(Integer id, UserDTO updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(updatedUser.getName());
            user.setRole(updatedUser.getRole());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            return UserMapper.toDTO(userRepository.save(user));
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public void deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    public User getUser(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    public List<UserDTO> getAllUsers() {
        return UserMapper.toDTOList(userRepository.findAll());
    }
}
