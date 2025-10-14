package com.epf.marmitax.services;

import com.epf.marmitax.DTO.UstensileMapper;
import org.springframework.stereotype.Service;

import com.epf.marmitax.DAO.UserDao;
import com.epf.marmitax.DTO.UserDto;
import com.epf.marmitax.DTO.UserMapper;
import com.epf.marmitax.models.User;

import jakarta.transaction.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public List<UserDto> findAll() {
        return userDao
                .findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDto getById(Long id){
        return userDao
                .findById(id)
                .map(UserMapper::toDto)
                .orElseThrow();
    }

    @Transactional
    public void deleteById(Long id){
        userDao.deleteById(id);
    }

     
    @Transactional
    public void addUser(UserDto userDto) {
        User user;
        user = UserMapper.fromDto(userDto, null);
        userDao.save(user);  
    }

    @Transactional
    public void updateUser(UserDto userDto, Long id) {
        userDao.findById(id).orElseThrow(() -> new NoSuchElementException("Le user n'existe pas"));
        User user;
        user = UserMapper.fromDto(userDto, id);
        userDao.save(user);
    }

    // TODO Rechercher une user par catégorie
    // public List<User> searchByCategorie(int categorieId) {
    //    return userDao.findByCategorieId(categorieId);
    //}
}
