package com.dto_project.dto_project.service;

import com.dto_project.dto_project.dto.UserDto;
import com.dto_project.dto_project.entity.User;
import com.dto_project.dto_project.exceptions.UserNotFoundException;
import com.dto_project.dto_project.mapper.UserMapper;
import com.dto_project.dto_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        //User user = UserMapper.INSTANCE.toEntity(userDto); // ???
        return userRepository.save(user);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        //return UserMapper.INSTANCE.toDto(user); // ???
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User deleteUserById(Integer id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        existingUser.setDeletion(true);
        return userRepository.save(existingUser);
    }

    public User updateUserById(User user, Integer id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setSecondName(user.getSecondName());
        existingUser.setAge(user.getAge());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }
}
