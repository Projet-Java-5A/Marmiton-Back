package com.epf.marmitax.services;

import org.springframework.stereotype.Service;

import com.epf.marmitax.DAO.CategorieDao;
import com.epf.marmitax.DTO.CategorieSimpleDto;
import com.epf.marmitax.DTO.CategorieDto;
import com.epf.marmitax.mappers.CategorieMapper;
import com.epf.marmitax.models.Categorie;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
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

    public CategorieSimpleDto getById(Long id){
        return categorieDao
                .findById(id)
                .map(CategorieMapper::toSimpleDto)
                .orElseThrow();
    }

    @Transactional
    public void deleteById(Long id){
        categorieDao.deleteById(id);
    }
 
    @Transactional
    public void addCategorie(CategorieSimpleDto categorieDto) {
        Categorie categorie = CategorieMapper.fromDto(categorieDto);
        categorieDao.save(categorie);  
    }

    @Transactional
    public void updateCategorie(CategorieSimpleDto categorieDto) {
        categorieDao.findById(categorieDto.idCategorieDto()).orElseThrow(() -> new NoSuchElementException("La categorie n'existe pas"));
        Categorie categorie;
        categorie = CategorieMapper.fromDto(categorieDto);
        categorieDao.save(categorie);
    }

}
