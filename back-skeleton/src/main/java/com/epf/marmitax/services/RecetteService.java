package com.epf.marmitax.services;

import com.epf.marmitax.DTO.UstensileMapper;
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
import java.util.stream.Collectors;

@Service
public class RecetteService {
    private final RecetteDao recetteDao;

    public RecetteService(RecetteDao recetteDao){
        this.recetteDao = recetteDao;
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

    // TODO Rechercher une recette par catégorie
    // public List<Recette> searchByCategorie(int categorieId) {
    //    return recetteDao.findByCategorieId(categorieId);
    //}
}
