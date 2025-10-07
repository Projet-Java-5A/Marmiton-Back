package com.epf.marmitax.controllers;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.marmitax.DTO.UserDto;
import com.epf.marmitax.models.User;
import com.epf.marmitax.services.UserService;

@CrossOrigin
@RequestMapping("users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PostMapping("")
    public void addUser(@RequestBody UserDto userDto) throws IOException {
        userService.addUser(userDto);
    }

    @PostMapping("/{id}")
    public void updateUser(@RequestBody UserDto userDto, @PathVariable Long id) throws IOException {
        userService.updateUser(userDto, id);
    }
}
