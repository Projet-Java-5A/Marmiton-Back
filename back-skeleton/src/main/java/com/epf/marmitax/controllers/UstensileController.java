package com.epf.marmitax.controllers;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.marmitax.DTO.UstensileDto;
import com.epf.marmitax.models.Ustensile;
import com.epf.marmitax.services.UstensileService;

@CrossOrigin
@RequestMapping("ustensiles")
@RestController
public class UstensileController {
    private final UstensileService ustensileService;

    public UstensileController(UstensileService ustensileService) {
        this.ustensileService = ustensileService;
    }

    @GetMapping("/{id}")
    public Ustensile getUstensileById(@PathVariable Long id) {
        return ustensileService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUstensile(@PathVariable Long id) {
        ustensileService.deleteById(id);
    }

    @PostMapping("")
    public void addUstensile(@RequestBody UstensileDto ustensileDto) throws IOException {
        ustensileService.addUstensile(ustensileDto);
    }

    @PostMapping("/{id}")
    public void updateUstensile(@RequestBody UstensileDto ustensileDto, @PathVariable Long id) throws IOException {
        ustensileService.updateUstensile(ustensileDto, id);
    }
}
