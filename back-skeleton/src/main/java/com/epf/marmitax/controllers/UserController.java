package com.epf.marmitax.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.epf.marmitax.DTO.UserDto;
import com.epf.marmitax.services.UserService;

import java.util.List;

@CrossOrigin
@RequestMapping("users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllUsers() {
        try {
            List<UserDto> users = userService.findAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la récupération des utilisateurs : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            UserDto user = userService.getById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la récupération de l'utilisateur : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la suppression de l'utilisateur : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        try {
            userService.addUser(userDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la création de l'utilisateur : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
        try {
            userService.updateUser(userDto, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la modification de l'utilisateur : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
