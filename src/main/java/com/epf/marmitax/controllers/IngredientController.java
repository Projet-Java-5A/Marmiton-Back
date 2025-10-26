package com.epf.marmitax.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.epf.marmitax.DTO.IngredientCreateDTO;
import com.epf.marmitax.DTO.IngredientDto;
import com.epf.marmitax.DTO.IngredientListDTO;
import com.epf.marmitax.services.IngredientService;

import java.util.List;

@CrossOrigin
@RequestMapping("ingredients")
@RestController
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllIngredients() {
        try {
            List<IngredientListDTO> ingredients =  ingredientService.findAllSimple();
            return new ResponseEntity<>(ingredients, HttpStatus.OK);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la récupération des ingrédients : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIngredientById(@PathVariable Long id) {
        try {
            IngredientDto ingredient = ingredientService.getById(id);
            return new ResponseEntity<>(ingredient, HttpStatus.OK);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la récupération de l'ingrédient : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIngredient(@PathVariable Long id) {
        try {
            ingredientService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la suppression de l'ingrédient : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> addIngredient(@RequestBody IngredientCreateDTO ingredientDto) {
        try {
            ingredientService.saveIngredientFromDto(ingredientDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la création de l'ingrédient : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateIngredient(@RequestBody IngredientDto ingredientDto, @PathVariable Long id) {
        try {
            ingredientService.updateIngredient(ingredientDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la modification de l'ingrédient : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
