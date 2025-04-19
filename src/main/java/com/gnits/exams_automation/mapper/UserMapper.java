package com.gnits.exams_automation.mapper;

import com.gnits.exams_automation.entity.User;
import com.gnits.exams_automation.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

// Class to map UserDTO to UserEntity and vice versa
public class UserMapper {
    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getRole(), user.getEmail(), user.getPassword());
    }

    public static User toEntity(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getRole(), userDTO.getEmail(), userDTO.getPassword());
    }
    // method to convert a list of UserDTO to a list of User
    public static List<UserDTO> toDTOList(List<User> users) {
        return users.stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }

}
