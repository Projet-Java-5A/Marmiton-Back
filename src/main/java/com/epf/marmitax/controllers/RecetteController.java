package com.epf.marmitax.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.epf.marmitax.DTO.RecetteCreateDTO;
import com.epf.marmitax.DTO.RecetteDto;
import com.epf.marmitax.DTO.StatusUpdateDto;
import com.epf.marmitax.services.RecetteService;

import java.util.List;

@CrossOrigin
@RequestMapping("recettes")
@RestController
public class RecetteController {
    private final RecetteService recetteService;

    public RecetteController(RecetteService recetteService) {
        this.recetteService = recetteService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllPublicRecettes() {
        try {
            List<RecetteDto> recettes = recetteService.findAll();
            return new ResponseEntity<>(recettes, HttpStatus.OK);
        } catch(Exception e){
            String errorMessage = "Une erreur est survenue lors de la récupération des recettes : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRecetteById(@PathVariable Long id) {
        try {
            RecetteDto recette = recetteService.getById(id);
            return new ResponseEntity<>(recette, HttpStatus.OK);
        } catch(Exception e){
            String errorMessage = "Une erreur est survenue lors de la récupération de la recette : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> addRecette(@RequestBody RecetteCreateDTO recetteCreateDTO) {
        try {
            recetteService.createRecette(recetteCreateDTO);
            java.util.Map<String, String> response = new java.util.HashMap<>();
            response.put("message", "Recette créée, en attente de validation.");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch(Exception e){
            String errorMessage = "Une erreur est survenue lors de la création de la recette : " + e.getMessage();
            java.util.Map<String, String> errorResponse = new java.util.HashMap<>();
            errorResponse.put("error", errorMessage);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/admin/pending")
    public ResponseEntity<List<RecetteDto>> getAllPendingRecettes() {
        List<RecetteDto> recettes = recetteService.findAllPending();
        return new ResponseEntity<>(recettes, HttpStatus.OK);
    }

    @GetMapping("/admin/rejected")
    public ResponseEntity<List<RecetteDto>> getAllRejectedRecettes() {
        List<RecetteDto> recettes = recetteService.findAllRejected();
        return new ResponseEntity<>(recettes, HttpStatus.OK);
    }

    @GetMapping("/admin/all")
    public ResponseEntity<List<RecetteDto>> getAllAdminRecettes() {
        List<RecetteDto> recettes = recetteService.findAllAdmin();
        return new ResponseEntity<>(recettes, HttpStatus.OK);
    }

    @PutMapping("/admin/{id}/status")
    public ResponseEntity<?> updateRecetteStatus(@PathVariable Long id, @RequestBody StatusUpdateDto statusDto) {
        try {
            recetteService.updateRecetteStatus(id, statusDto.getStatus());
            return new ResponseEntity<>("Statut de la recette mis à jour.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la mise à jour du statut: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecette(@PathVariable Long id) {
        try {
            recetteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            String errorMessage = "Une erreur est survenue lors de la suppression de la recette : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRecette(@RequestBody RecetteDto recetteDto, @PathVariable Long id) {
        try {
            recetteService.updateRecette(recetteDto, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            String errorMessage = "Une erreur est survenue lors de la modification de la recette : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchRecettes(@RequestParam("search") String query) {
        try {
            List<RecetteDto> recettes = recetteService.searchByNom(query);
            return new ResponseEntity<>(recettes, HttpStatus.OK);
        } catch(Exception e){
            String errorMessage = "Une erreur est survenue lors de la recherche des recettes : " + e.getMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
