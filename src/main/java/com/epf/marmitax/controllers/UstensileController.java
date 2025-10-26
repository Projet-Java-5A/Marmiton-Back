package com.epf.marmitax.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.epf.marmitax.DTO.UstensileDto;
import com.epf.marmitax.services.UstensileService;

@CrossOrigin
@RequestMapping("ustensiles")
@RestController
public class UstensileController {
    private final UstensileService ustensileService;

    public UstensileController(UstensileService ustensileService) {
        this.ustensileService = ustensileService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllUstensiles() {
        try {
            List<UstensileDto> ustensiles = ustensileService.findAll();
            return new ResponseEntity<>(ustensiles, HttpStatus.OK);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la récupération des ustensiles : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUstensileById(@PathVariable Long id) {
        try {
            UstensileDto ustensile = ustensileService.getById(id);
            return new ResponseEntity<>(ustensile, HttpStatus.OK);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la récupération de l'ustensile : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUstensile(@PathVariable Long id) {
        try {
            ustensileService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la suppression de l'ustensile : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> addUstensile(@RequestBody UstensileDto ustensileDto) throws IOException {
        try {
            ustensileService.addUstensile(ustensileDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la création de l'ustensile : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUstensile(@RequestBody UstensileDto ustensileDto, @PathVariable Long id) throws IOException {
        try {
            ustensileService.updateUstensile(ustensileDto, id);
            return new ResponseEntity<>(HttpStatus.OK);  
        } catch(Exception e){// TODO mieux définir les erreurs
            String errorMessage = "Une erreur est survenue lors de la modification de l'ustensile : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
