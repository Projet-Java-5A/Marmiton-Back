package com.epf.marmitax.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epf.marmitax.models.User;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
    Optional<User> findByMailUser(String mailUser);
}
