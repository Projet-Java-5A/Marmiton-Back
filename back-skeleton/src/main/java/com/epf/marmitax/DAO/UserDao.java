package com.epf.marmitax.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epf.marmitax.models.User;
@Repository
public interface UserDao extends JpaRepository<User, Long>{
    
}
