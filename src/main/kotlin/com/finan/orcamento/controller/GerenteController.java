package com.finan.orcamento.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finan.orcamento.model.GerenteModel;
import com.finan.orcamento.service.GerenteService;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/gerentes")
public class GerenteController {
    @Autowired
    private GerenteService gerenteService;

    @PostMapping("/")
    public GerenteModel createGerente(@RequestBody GerenteModel gerente) {
        return gerenteService.saveGerente(gerente);
    }

    @GetMapping("/")
    public List<GerenteModel> getAllGerentes() {
        return gerenteService.getAllGerentes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GerenteModel> getGerenteById(@PathVariable Long id) {
        GerenteModel gerente = gerenteService.getGerenteById(id);
        return ResponseEntity.ok().body(gerente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GerenteModel> updateGerente(@PathVariable Long id, @RequestBody GerenteModel gerenteDetails) {
        GerenteModel updatedGerente = gerenteService.updateGerente(id, gerenteDetails);
        return ResponseEntity.ok().body(updatedGerente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGerente(@PathVariable Long id) {
        gerenteService.deleteGerente(id);
        return ResponseEntity.ok().build();
    }
}