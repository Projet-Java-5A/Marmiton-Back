package com.epf.marmitax.services;

import org.springframework.stereotype.Service;

import com.epf.marmitax.DAO.RecetteDao;
import com.epf.marmitax.DTO.RecetteDto;
import com.epf.marmitax.DTO.RecetteMapper;
import com.epf.marmitax.models.Recette;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.NoSuchElementException;

@Service
public class RecetteService {
    private final RecetteDao recetteDao;

    public RecetteService(RecetteDao recetteDao){
        this.recetteDao = recetteDao;
    }

    public List<Recette> findAll() {
        Iterable<Recette> it = recetteDao.findAll();
        List <Recette> recettes = new ArrayList<>();
        it.forEach(recettes::add);
        return recettes;
    }

    public Recette getById(Long id){
        return recetteDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id){
        recetteDao.deleteById(id);
    }

    @Transactional
    public void addRecette(RecetteDto recetteDto) throws IOException {
        Recette recette;
        recette = RecetteMapper.fromDto(recetteDto);
        recetteDao.save(recette);  
    }

    @Transactional
    public void updateRecette(RecetteDto recetteDto, Long id) throws IOException {
        recetteDao.findById(id).orElseThrow(() -> new NoSuchElementException("La recette n'existe pas"));
        Recette recette;
        recette = RecetteMapper.fromDto(recetteDto);
        recetteDao.save(recette);
    }

    // TODO Rechercher une recette par catégorie
    // public List<Recette> searchByCategorie(int categorieId) {
    //    return recetteDao.findByCategorieId(categorieId);
    //}
}
