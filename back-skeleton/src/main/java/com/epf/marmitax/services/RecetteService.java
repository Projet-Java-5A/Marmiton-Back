package com.epf.marmitax.services;

import com.epf.marmitax.DAO.IngredientDao;
import com.epf.marmitax.DAO.UserDao;
import com.epf.marmitax.DAO.UstensileDao;
import com.epf.marmitax.DTO.IngredientQuantiteDTO;
import com.epf.marmitax.DTO.RecetteCreateDTO;
import com.epf.marmitax.models.*;
import org.springframework.stereotype.Service;

import com.epf.marmitax.DAO.RecetteDao;
import com.epf.marmitax.DTO.RecetteDto;
import com.epf.marmitax.DTO.RecetteMapper;

import jakarta.transaction.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
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
                .findAll()
                .stream()
                .map(RecetteMapper::toDto)
                .collect(Collectors.toList());
    }

    public RecetteDto getById(Long id){
        return recetteDao
                .findById(id)
                .map(RecetteMapper::toDto)
                .orElseThrow();
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
        recetteDao.findById(id).orElseThrow(() -> new NoSuchElementException("La recette n'existe pas"));
        Recette recette;
        recette = RecetteMapper.fromDto(recetteDto);
        recetteDao.save(recette);
    }

}
