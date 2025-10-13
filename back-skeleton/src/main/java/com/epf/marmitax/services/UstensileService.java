package com.epf.marmitax.services;

import org.springframework.stereotype.Service;

import com.epf.marmitax.DAO.UstensileDao;
import com.epf.marmitax.DTO.UstensileDto;
import com.epf.marmitax.DTO.UstensileMapper;
import com.epf.marmitax.models.Ustensile;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;

@Service
public class UstensileService {
    private final UstensileDao ustensileDao;

    public UstensileService(UstensileDao ustensileDao){
        this.ustensileDao = ustensileDao;
    }

    // Retourner toutes les ustensiles de la BDD
    public List<Ustensile> findAll() {
        Iterable<Ustensile> it = ustensileDao.findAll();
        List <Ustensile> ustensiles = new ArrayList<>();
        it.forEach(ustensiles::add);
        return ustensiles;
    }

    // Retourner une ustensile par un Id
    public Ustensile getById(Long id){
        return ustensileDao.findById(id).orElseThrow();
    }

    // Supprimer une ustensile par son id
    @Transactional // Réalisé par une transaction
    public void deleteById(Long id){
        ustensileDao.deleteById(id);
    }

     
    // Ajouter une nouvelle ustensile
    @Transactional
    public void addUstensile(UstensileDto ustensileDto) {
        Ustensile ustensile;
        ustensile = UstensileMapper.fromDto(ustensileDto);
        ustensileDao.save(ustensile);  
    }

    // Modifier une ustensile
    @Transactional
    public void updateUstensile(UstensileDto ustensileDto, Long id) {
        ustensileDao.findById(id).orElseThrow(() -> new NoSuchElementException("La ustensile n'existe pas"));
        Ustensile ustensile;
        ustensile = UstensileMapper.fromDto(ustensileDto);
        ustensileDao.save(ustensile);
    }

    // Rechercher une ustensile par catégorie
    // public List<Ustensile> searchByCategorie(int categorieId) {
    //    return ustensileDao.findByCategorieId(categorieId);
    //}
}
