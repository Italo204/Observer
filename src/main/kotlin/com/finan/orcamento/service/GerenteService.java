package com.finan.orcamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finan.orcamento.model.GerenteModel;
import com.finan.orcamento.repositories.GerenteRepository;

@Service
public class GerenteService {
    
    @Autowired
    private GerenteRepository gerenteRepository;

    public GerenteModel saveGerente(GerenteModel gerente) {
        return gerenteRepository.save(gerente);
    }

    public List<GerenteModel> getAllGerentes() {
        return gerenteRepository.findAll();
    }

    public GerenteModel getGerenteById(Long id) {
        return gerenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Gerente não encontrado"));
    }

    public GerenteModel updateGerente(Long id, GerenteModel gerenteDetails) {
        GerenteModel gerente = getGerenteById(id);
        gerente.setNome(gerenteDetails.getNome());;
        return gerenteRepository.save(gerente);
    }

    public void deleteGerente(Long id) {
        gerenteRepository.deleteById(id);
    }
} 
