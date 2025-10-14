package com.epf.marmitax.services;

import com.epf.marmitax.DTO.UstensileMapper;
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
import java.util.stream.Collectors;

@Service
public class CategorieService {
    private final CategorieDao categorieDao;

    public CategorieService(CategorieDao categorieDao){
        this.categorieDao = categorieDao;
    }

    public List<CategorieDto> findAll() {
        return categorieDao
                .findAll()
                .stream()
                .map(CategorieMapper::toDto)
                .collect(Collectors.toList());
    }

    public CategorieDto getById(Long id){
        return categorieDao
                .findById(id)
                .map(CategorieMapper::toDto)
                .orElseThrow();
    }

    @Transactional
    public void deleteById(Long id){
        categorieDao.deleteById(id);
    }
 
    @Transactional
    public void addCategorie(CategorieDto categorieDto) {
        Categorie categorie = CategorieMapper.fromDto(categorieDto);
        categorieDao.save(categorie);  
    }

    @Transactional
    public void updateCategorie(CategorieDto categorieDto) {
        categorieDao.findById(categorieDto.idCategorieDto()).orElseThrow(() -> new NoSuchElementException("La categorie n'existe pas"));
        Categorie categorie;
        categorie = CategorieMapper.fromDto(categorieDto);
        categorieDao.save(categorie);
    }

}
