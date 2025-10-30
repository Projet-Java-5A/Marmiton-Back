package com.epf.marmitax.DAO;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epf.marmitax.models.ApprovalStatus;
import com.epf.marmitax.models.Recette;
@Repository
public interface RecetteDao extends JpaRepository<Recette, Long>{

    List<Recette> findAllByApprovalStatus(ApprovalStatus approvalStatus);
    List<Recette> findByNomRecetteContainingIgnoreCaseAndApprovalStatus(String nomRecette, ApprovalStatus status);
    
}
