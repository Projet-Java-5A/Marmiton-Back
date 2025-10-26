package com.epf.marmitax.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epf.marmitax.models.Ustensile;

@Repository
public interface UstensileDao extends JpaRepository<Ustensile, Long> {
    
}
