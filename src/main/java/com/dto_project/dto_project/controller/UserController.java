package com.dto_project.dto_project.controller;

import com.dto_project.dto_project.dto.UserDto;
import com.dto_project.dto_project.entity.User;
import com.dto_project.dto_project.mapper.UserMapper;
import com.dto_project.dto_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    private UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @PostMapping(value = "/user")
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userMapper.toDto(userService.saveUser(userDto));
    }

   /* @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable(value = "id") Integer id) {
        return userService.getUserById(id);
    }

    @DeleteMapping(value = "/user/{id}")
    public User deleteUser
            (@PathVariable(value = "id") Integer id) {
        return userService.deleteUserById(id);
    }

    @PutMapping(value = "/user/{id}")
    public User updateUserById
            (@RequestBody User user, @PathVariable(value = "id") Integer id) {
        return userService.updateUserById(user, id);
    }*/
}
