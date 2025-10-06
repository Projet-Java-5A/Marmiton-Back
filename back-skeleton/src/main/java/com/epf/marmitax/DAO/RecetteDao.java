package com.epf.marmitax.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epf.marmitax.models.Recette;
@Repository
public interface RecetteDao extends JpaRepository<Recette, Long>{
    
}
