package com.epf.marmitax.services;

import com.epf.marmitax.DAO.IngredientDao;
import com.epf.marmitax.DAO.UserDao;
import com.epf.marmitax.DAO.UstensileDao;
import com.epf.marmitax.DTO.IngredientQuantiteDTO;
import com.epf.marmitax.DTO.RecetteCreateDTO;
import com.epf.marmitax.models.*;
import com.epf.marmitax.mappers.UstensileMapper;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.HashSet;

import com.epf.marmitax.DAO.RecetteDao;
import com.epf.marmitax.DTO.RecetteDto;
import com.epf.marmitax.mappers.RecetteMapper;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RecetteService {
    private final RecetteDao recetteDao;
    private final UserDao userDao;
    private final IngredientDao ingredientDao;
    private final UstensileDao ustensileDao;

    public RecetteService(RecetteDao recetteDao, UserDao userDao, IngredientDao ingredientDao, UstensileDao ustensileDao){
        this.recetteDao = recetteDao;
        this.userDao = userDao;
        this.ingredientDao = ingredientDao;
        this.ustensileDao = ustensileDao;
    }

    @Transactional
    public Recette createRecette(RecetteCreateDTO recetteCreateDTO) {
        Recette recette = new Recette();
        recette.setNomRecette(recetteCreateDTO.getNomRecette());
        recette.setDureeRecette(recetteCreateDTO.getDureeRecette());
        recette.setDifficulteRecette(recetteCreateDTO.getDifficulteRecette());
        recette.setPrixRecette((int) recetteCreateDTO.getPrixRecette());
        recette.setImageRecette(recetteCreateDTO.getImageRecette());
        recette.setContenuRecette(recetteCreateDTO.getContenuRecette());

        User user = userDao.findById(recetteCreateDTO.getUtilisateurId())
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        recette.setUtilisateurs(user);

        if (recetteCreateDTO.getUstensilesIds() != null) {
            List<Ustensile> ustensiles = ustensileDao.findAllById(recetteCreateDTO.getUstensilesIds());
            recette.setUstensiles(ustensiles);
        }

        Set<RecetteIngredient> recetteIngredients = new HashSet<>();
        if (recetteCreateDTO.getIngredients() != null) {
            for (IngredientQuantiteDTO iqDto : recetteCreateDTO.getIngredients()) {
                Ingredient ingredient = ingredientDao.findById(iqDto.getIngredientId())
                        .orElseThrow(() -> new NoSuchElementException("Ingredient not found"));
                
                recetteIngredients.add(new RecetteIngredient(recette, ingredient, iqDto.getQuantite()));
            }
        }
        recette.setRecetteIngredients(recetteIngredients);

        return recetteDao.save(recette);
    }

    public List<RecetteDto> findAll() {
        return recetteDao
                .findAllByApprovalStatus(ApprovalStatus.APPROVED)
                .stream()
                .map(RecetteMapper::toDto)
                .collect(Collectors.toList());
    }

    public RecetteDto getById(Long id){
        Recette recette = recetteDao.findById(id).orElseThrow(() -> new NoSuchElementException("Recette non trouvée"));
        if(recette.getApprovalStatus() != ApprovalStatus.APPROVED) {
            throw new NoSuchElementException("Cette recette n'est pas disponible.");
        }
        return RecetteMapper.toDto(recette);
    }

    public List<RecetteDto> searchByNom(String query) {
        return recetteDao
                .findByNomRecetteContainingIgnoreCaseAndApprovalStatus(query, ApprovalStatus.APPROVED)
                .stream()
                .map(RecetteMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RecetteDto> findAllPending() {
        return recetteDao.findAllByApprovalStatus(ApprovalStatus.PENDING)
            .stream()
            .map(RecetteMapper::toDto)
            .collect(Collectors.toList());
    }

    public List<RecetteDto> findAllRejected() {
        return recetteDao.findAllByApprovalStatus(ApprovalStatus.REJECTED)
            .stream()
            .map(RecetteMapper::toDto)
            .collect(Collectors.toList());
    }

    public List<RecetteDto> findAllAdmin() {
        return recetteDao.findAll()
            .stream()
            .map(RecetteMapper::toDto)
            .collect(Collectors.toList());
    }

    @Transactional
    public void updateRecetteStatus(Long id, ApprovalStatus status) {
        Recette recette = recetteDao.findById(id).orElseThrow(() -> new NoSuchElementException("Recette non trouvée"));
        recette.setApprovalStatus(status);
        recetteDao.save(recette);
    }

    @Transactional
    public void deleteById(Long id){
        recetteDao.deleteById(id);
    }

    @Transactional
    public void addRecette(RecetteDto recetteDto) {
        Recette recette;
        recette = RecetteMapper.fromDto(recetteDto);
        recetteDao.save(recette);  
    }

    @Transactional
    public void updateRecette(RecetteDto recetteDto, Long id) {
        Recette recette = recetteDao.findById(id).orElseThrow(() -> new NoSuchElementException("La recette n'existe pas"));
        
        recette.setNomRecette(recetteDto.nomRecetteDto());
        recette.setDureeRecette(recetteDto.dureeRecetteDto());
        recette.setDifficulteRecette(recetteDto.difficulteRecetteDto());
        recette.setPrixRecette(recetteDto.prixRecetteDto());
        recette.setImageRecette(recetteDto.imageRecetteDto());
        recette.setContenuRecette(recetteDto.contenuRecetteDto());

        recetteDao.save(recette);
        
        Set<RecetteIngredient> newIngredients = new HashSet<>();
        
        recetteDto.ingredientsDto().forEach(ingredientDto -> {
            Ingredient ingredient = ingredientDao.findById(ingredientDto.id())
                .orElseThrow(() -> new NoSuchElementException("Ingredient non trouvé: " + ingredientDto.id()));
            
            RecetteIngredient recetteIngredient = new RecetteIngredient();
            recetteIngredient.setRecette(recette);
            recetteIngredient.setIngredient(ingredient);
            recetteIngredient.setQuantite(ingredientDto.quantite());
            
            RecetteIngredientId compositeId = new RecetteIngredientId(recette.getIdRecette(), ingredient.getIdIngredient());
            recetteIngredient.setId(compositeId);
            
            newIngredients.add(recetteIngredient);
        });
        
        recette.getRecetteIngredients().clear();
        recette.getRecetteIngredients().addAll(newIngredients);
        
        if (recetteDto.ustensilesDto() != null) {
            List<Ustensile> ustensiles = recetteDto.ustensilesDto().stream()
                .map(UstensileMapper::fromDto)
                .map(u -> ustensileDao.findById(u.getIdUstensile())
                    .orElseThrow(() -> new NoSuchElementException("Ustensile non trouvé")))
                .collect(Collectors.toList());
            recette.setUstensiles(ustensiles);
        }
        
        recetteDao.save(recette);
    }

}
