package com.example.brothersofadventure.itinerary.domain.controller;
import com.example.brothersofadventure.itinerary.domain.dto.GrupoDto;
import com.example.brothersofadventure.itinerary.domain.service.GrupoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/grupos")
public class GrupoController {

    private final GrupoService grupoService;

    @Autowired
    public GrupoController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @PostMapping
    public ResponseEntity<GrupoDto> createGrupo( @RequestBody GrupoDto grupoDto) {
        GrupoDto createdGrupo = grupoService.createGrupo(grupoDto);
        return new ResponseEntity<>(createdGrupo, HttpStatus.CREATED);
    }



    @DeleteMapping("/{grupoId}")
    public ResponseEntity<Void> deleteGrupo(@PathVariable Long grupoId) {
        grupoService.deleteGrupo(grupoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}