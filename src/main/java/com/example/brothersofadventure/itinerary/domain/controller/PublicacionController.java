package com.example.brothersofadventure.itinerary.domain.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.brothersofadventure.itinerary.domain.entity.Publicacion;
import com.example.brothersofadventure.itinerary.domain.service.PublicacionService;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    private final PublicacionService publicacionService;

    @Autowired
    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @PostMapping
    public ResponseEntity<Publicacion> crearPublicacion(@RequestBody Publicacion publicacion) {
        // Aquí debes implementar la lógica para crear una publicación
        Publicacion nuevaPublicacion = publicacionService.crearPublicacion(publicacion);
        return ResponseEntity.ok(nuevaPublicacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacionPorId(@PathVariable Long id) {
        Publicacion publicacion = publicacionService.obtenerPublicacionPorId(id);
        return ResponseEntity.ok(publicacion);
    }

    @GetMapping
    public ResponseEntity<List<Publicacion>> obtenerTodasLasPublicaciones() {
        List<Publicacion> publicaciones = publicacionService.obtenerTodasLasPublicaciones();
        return ResponseEntity.ok(publicaciones);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> actualizarPublicacion(@PathVariable Long id, @RequestBody Publicacion publicacion) {
        // Aquí debes implementar la lógica para actualizar una publicación por su ID
        Publicacion publicacionActualizada = publicacionService.actualizarPublicacion(id, publicacion);
        return ResponseEntity.ok(publicacionActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPublicacion(@PathVariable Long id) {
        publicacionService.eliminarPublicacion(id);
        return ResponseEntity.noContent().build();
    }
}
