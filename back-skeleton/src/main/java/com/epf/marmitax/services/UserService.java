package com.epf.marmitax.services;

import com.epf.marmitax.DTO.UserCreateDTO;
import org.springframework.stereotype.Service;

import com.epf.marmitax.DAO.UserDao;
import com.epf.marmitax.DTO.UserDto;
import com.epf.marmitax.DTO.UserMapper;
import com.epf.marmitax.models.User;

import javax.naming.AuthenticationException;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    @Transactional
    public User createUser(UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setIsAdmin(userCreateDTO.isAdmin());
        user.setNomUser(userCreateDTO.getNomUser());
        user.setPrenomUser(userCreateDTO.getPrenomUser());
        user.setMailUser(userCreateDTO.getMailUser());
        user.setMdpUser(userCreateDTO.getMdpUser());
        return userDao.save(user);
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

    public UserDto loginUser(String mailUser, String mdpUser) throws AuthenticationException {
        User user = userDao.findByMailUser(mailUser)
            .orElseThrow(() -> new AuthenticationException("User not found"));

        // ATTENTION: Comparaison de mot de passe en clair. C'est une faille de sécurité majeure.
        // Il est impératif de remplacer ceci par une vérification de mot de passe haché (ex: BCrypt).
        if (!user.getMdpUser().equals(mdpUser)) {
            throw new AuthenticationException("Invalid password");
        }

        return UserMapper.toDto(user);
    }

}
