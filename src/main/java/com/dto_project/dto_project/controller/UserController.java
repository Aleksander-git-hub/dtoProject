package com.dto_project.dto_project.controller;

import com.dto_project.dto_project.dto.UserDto;
import com.dto_project.dto_project.entity.User;
import com.dto_project.dto_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{id}")
    public User getUserById(@PathVariable(value = "id") Integer id) {
        return userService.getUserById(id);
    }

    @DeleteMapping(value = "/users/{id}")
    public User deleteUser
            (@PathVariable(value = "id") Integer id) {
        return userService.deleteUserById(id);
    }

    @PutMapping(value = "/users/{id}")
    public User updateUserById
            (@RequestBody User user, @PathVariable(value = "id") Integer id) {
        return userService.updateUserById(user, id);
    }
}
