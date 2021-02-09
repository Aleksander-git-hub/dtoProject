package com.dto_project.dto_project.service;

import com.dto_project.dto_project.dto.UserDto;
import com.dto_project.dto_project.entity.User;
import com.dto_project.dto_project.exceptions.NotFoundException;
import com.dto_project.dto_project.mapper.UserMapper;
import com.dto_project.dto_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User saveUser(UserDto userDto) {
        return userRepository.save(userMapper.toEntity(userDto));
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).
                orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        //return UserMapper.INSTANCE.toDto(user); // ???
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User deleteUserById(Integer id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        existingUser.setDeleted(true);
        return userRepository.save(existingUser);
    }

    public User updateUserById(User user, Integer id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setSecondName(user.getSecondName());
        existingUser.setAge(user.getAge());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }
}
