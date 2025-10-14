package com.epf.marmitax.services;

import org.springframework.stereotype.Service;

import com.epf.marmitax.DAO.UstensileDao;
import com.epf.marmitax.DTO.UstensileDto;
import com.epf.marmitax.DTO.UstensileMapper;
import com.epf.marmitax.models.Ustensile;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UstensileService {
    private final UstensileDao ustensileDao;

    public UstensileService(UstensileDao ustensileDao){
        this.ustensileDao = ustensileDao;
    }

    public List<UstensileDto> findAll() {
        return ustensileDao
                .findAll()
                .stream()
                .map(UstensileMapper::toDto)
                .collect(Collectors.toList());
    }

    public UstensileDto getById(Long id){
        return ustensileDao
                .findById(id)
                .map(UstensileMapper::toDto)
                .orElseThrow();
    }

    @Transactional
    public void deleteById(Long id){
        ustensileDao.deleteById(id);
    }

    @Transactional
    public void addUstensile(UstensileDto ustensileDto) {
        Ustensile ustensile = UstensileMapper.fromDto(ustensileDto);
        ustensileDao.save(ustensile);  
    }

    @Transactional
    public void updateUstensile(UstensileDto ustensileDto, Long id) {
        ustensileDao
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("L'ustensile n'existe pas"));
        Ustensile ustensile = UstensileMapper.fromDto(ustensileDto);
        ustensileDao.save(ustensile);
    }

    // TODO Rechercher une ustensile par catégorie
    // public List<Ustensile> searchByCategorie(int categorieId) {
    //    return ustensileDao.findByCategorieId(categorieId);
    //}
}
