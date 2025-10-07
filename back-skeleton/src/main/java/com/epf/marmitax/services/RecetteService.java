package com.epf.marmitax.services;

import org.springframework.stereotype.Service;

import com.epf.marmitax.DAO.RecetteDao;
import com.epf.marmitax.models.Recette;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.ArrayList;

@Service
public class RecetteService {
    private final RecetteDao recetteDao;

    public RecetteService(RecetteDao recetteDao){
        this.recetteDao = recetteDao;
    }

    // Retourner toutes les recettes de la BDD
    public List<Recette> findAll() {
        Iterable<Recette> it = recetteDao.findAll();
        List <Recette> recettes = new ArrayList<>();
        it.forEach(recettes::add);
        return recettes;
    }

    // Retourner une recette par un Id
    public Recette getById(Long id){
        return recetteDao.findById(id).orElseThrow();
    }

    // Supprimer une recette par son id
    @Transactional // Réalisé par une transaction
    public void deleteById(Long id){
        recetteDao.deleteById(id);
    }

    // Ajouter une nouvelle recette
    @Transactional
    public void addRecette(RecetteDto recetteDto){
        Recette recette;
        recette = RecetteMapper.fromDto(recetteDto, null);
        recetteDao.save(recette);  
    }

    // Modifier une recette
    @Transactional
    public void updateRecette(RecetteDto recetteDto, Long id) {
        recetteDao.findById(id).orElseThrow(() -> new NoSuchElementException("La recette n'existe pas"));
        Recette recette;
        recette = RecetteMapper.fromDto(recetteDto, id);
        recetteDao.save(recette);
    }

    // Rechercher une recette par catégorie
    // public List<Recette> searchByCategorie(int categorieId) {
    //    return recetteDao.findByCategorieId(categorieId);
    //}
}
