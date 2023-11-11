package com.example.brothersofadventure.itinerary.domain.service;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.example.brothersofadventure.itinerary.domain.dto.GrupoDto;
import com.example.brothersofadventure.itinerary.domain.entity.Grupo;
import com.example.brothersofadventure.itinerary.domain.exception.GrupoNotFoundException;
import com.example.brothersofadventure.itinerary.domain.repository.GrupoRepository;

import java.util.List;

@Service
@SpringBootApplication

public class GrupoService {

    private final GrupoRepository grupoRepository;

 
    public GrupoService(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    public Grupo createGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public Grupo getGrupoById(Long id) {
        return grupoRepository.findById(id)
                .orElseThrow(() -> new GrupoNotFoundException("Grupo no encontrado"));
    }

    public List<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }

    public Grupo updateGrupo(Long id, Grupo grupo) {
        if (!grupoRepository.existsById(id)) {
            throw new GrupoNotFoundException("Grupo no encontrado");
        }
        grupo.setId(id);
        return grupoRepository.save(grupo);
    }

    public void deleteGrupo(Long id) {
        if (!grupoRepository.existsById(id)) {
            throw new GrupoNotFoundException("Grupo no encontrado");
        }
        grupoRepository.deleteById(id);
    }

    public GrupoDto createGrupo(Object grupo) {
        return null;
    }

    
}
