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

    public List<Categorie> findAll() {
        Iterable<Categorie> it = categorieDao.findAll();
        List <Categorie> categories = new ArrayList<>();
        it.forEach(categories::add);
        return categories;
    }

    public Categorie getById(Long id){
        return categorieDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id){
        categorieDao.deleteById(id);
    }
 
    @Transactional
    public void addCategorie(CategorieDto categorieDto) throws IOException {
        Categorie categorie = CategorieMapper.fromDto(categorieDto);
        categorieDao.save(categorie);  
    }

    @Transactional
    public void updateCategorie(CategorieDto categorieDto) {
        categorieDao.findById(categorieDto.idCategorieDto()).orElseThrow(() -> new NoSuchElementException("L'ingrédient n'existe pas Evannnnnnnnnnnnn"));
        Categorie categorie;
        categorie = CategorieMapper.fromDto(categorieDto);
        categorieDao.save(categorie);
    }

}
