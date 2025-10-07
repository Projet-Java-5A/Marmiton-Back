package com.epf.marmitax.services;

import org.springframework.stereotype.Service;

import com.epf.marmitax.DAO.CategorieDao;
import com.epf.marmitax.DTO.CategorieMapper;
import com.epf.marmitax.DTO.CategorieDto;
import com.epf.marmitax.models.Categorie;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class CategorieService {
    private final CategorieDao categorieDao;

    public CategorieService(CategorieDao categorieDao){
        this.categorieDao = categorieDao;
    }

    // Retourner tous les ingrédients de la BDD
    public List<Categorie> findAll() {
        Iterable<Categorie> it = categorieDao.findAll();
        List <Categorie> categories = new ArrayList<>();
        it.forEach(categories::add);
        return categories;
    }

    // Retourner un categorie par un Id
    public Categorie getById(Long id){
        return categorieDao.findById(id).orElseThrow();
    }

    // Supprimer un ingrédient par son id
    @Transactional // Réalisé par une transaction
    public void deleteById(Long id){
        categorieDao.deleteById(id);
    }
 
    // Ajouter un nouvel ingrédient
    @Transactional
    public void addCategorie(CategorieDto categorieDto) throws IOException {
        Categorie categorie;
        categorie = CategorieMapper.fromDto(categorieDto, null);
        categorieDao.save(categorie);  
    }

    // Modifier un ingrédient
    @Transactional
    public void updateCategorie(CategorieDto categorieDto, Long id) throws IOException {
        categorieDao.findById(id).orElseThrow(() -> new NoSuchElementException("L'ingrédient n'existe pas Evannnnnnnnnnnnn"));
        Categorie categorie;
        categorie = CategorieMapper.fromDto(categorieDto, id);
        categorieDao.save(categorie);
    }

    // Rechercher un ingrédient par catégorie
    // public List<Categorie> searchByCategorie(int categorieId) {
    //    return categorieDao.findByCategorieId(categorieId);
    //}
}
