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

    public List<Ustensile> findAll() {
        Iterable<Ustensile> it = ustensileDao.findAll();
        List <Ustensile> ustensiles = new ArrayList<>();
        it.forEach(ustensiles::add);
        return ustensiles;
    }

    public Ustensile getById(Long id){
        return ustensileDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id){
        ustensileDao.deleteById(id);
    }

    @Transactional
    public void addUstensile(UstensileDto ustensileDto) {
        Ustensile ustensile;
        ustensile = UstensileMapper.fromDto(ustensileDto);
        ustensileDao.save(ustensile);  
    }

    @Transactional
    public void updateUstensile(UstensileDto ustensileDto, Long id) {
        ustensileDao.findById(id).orElseThrow(() -> new NoSuchElementException("La ustensile n'existe pas"));
        Ustensile ustensile;
        ustensile = UstensileMapper.fromDto(ustensileDto);
        ustensileDao.save(ustensile);
    }

    // TODO Rechercher une ustensile par catégorie
    // public List<Ustensile> searchByCategorie(int categorieId) {
    //    return ustensileDao.findByCategorieId(categorieId);
    //}
}
