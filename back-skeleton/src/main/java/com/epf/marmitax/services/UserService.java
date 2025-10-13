package com.epf.marmitax.services;

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
@Service

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public List<User> findAll() {
        Iterable<User> it = userDao.findAll();
        List <User> users = new ArrayList<>();
        it.forEach(users::add);
        return users;
    }

    public User getById(Long id){
        return userDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id){
        userDao.deleteById(id);
    }

     
    @Transactional
    public void addUser(UserDto userDto) throws IOException {
        User user;
        user = UserMapper.fromDto(userDto, null);
        userDao.save(user);  
    }

    @Transactional
    public void updateUser(UserDto userDto, Long id) throws IOException {
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
