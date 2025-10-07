package com.epf.marmitax.services;

import org.springframework.stereotype.Service;

import com.epf.marmitax.DAO.UserDao;
import com.epf.marmitax.models.User;

import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    // Retourner toutes les users de la BDD
    public List<User> findAll() {
        Iterable<User> it = userDao.findAll();
        List <User> users = new ArrayList<>();
        it.forEach(users::add);
        return users;
    }

    // Retourner une user par un Id
    public User getById(Long id){
        return userDao.findById(id).orElseThrow();
    }

    // Supprimer une user par son id
    @Transactional // Réalisé par une transaction
    public void deleteById(Long id){
        userDao.deleteById(id);
    }

     
    // Ajouter une nouvelle user
    @Transactional
    public void addUser(UserDto userDto){
        User user;
        user = UserMapper.fromDto(userDto, null);
        userDao.save(user);  
    }

    // Modifier une user
    @Transactional
    public void updateUser(UserDto userDto, Long id) {
        userDao.findById(id).orElseThrow(() -> new NoSuchElementException("Le user n'existe pas"));
        User user;
        user = UserMapper.fromDto(userDto, id);
        userDao.save(user);
    }

    // Rechercher une user par catégorie
    // public List<User> searchByCategorie(int categorieId) {
    //    return userDao.findByCategorieId(categorieId);
    //}
}
