package com.example.brothersofadventure.itinerary.domain.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.brothersofadventure.itinerary.domain.entity.Publicacion;
import com.example.brothersofadventure.itinerary.domain.exception.PublicacionNotFoundException;
import com.example.brothersofadventure.itinerary.domain.repository.PublicacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {

    private final PublicacionRepository publicacionRepository;

    @Autowired
    public PublicacionService(PublicacionRepository publicacionRepository) {
        this.publicacionRepository = publicacionRepository;
    }

    @Transactional
    public Publicacion crearPublicacion(Publicacion publicacion) {

        return publicacionRepository.save(publicacion);
    }

    public Publicacion obtenerPublicacionPorId(Long id) {
        Optional<Publicacion> publicacionOptional = publicacionRepository.findById(id);
        if (publicacionOptional.isPresent()) {
            return publicacionOptional.get();
        } else {
            // Puedes manejar el caso en el que no se encuentre la publicación
            throw new PublicacionNotFoundException("Publicación no encontrada");
        }
    }

    public List<Publicacion> obtenerTodasLasPublicaciones() {
        return publicacionRepository.findAll();
    }

    @Transactional
    public Publicacion actualizarPublicacion(Long id, Publicacion publicacion) {
        // Agrega aquí la lógica para actualizar una publicación por su ID
        if (publicacionRepository.existsById(id)) {
            publicacion.setId(id);
            return publicacionRepository.save(publicacion);
        } else {
            // Manejo de error: la publicación no existe
            throw new PublicacionNotFoundException("Publicación no encontrada");
        }
    }

    @Transactional
    public void eliminarPublicacion(Long id) {
        if (publicacionRepository.existsById(id)) {
            publicacionRepository.deleteById(id);
        } else {
            // Manejo de error: la publicación no existe
            throw new PublicacionNotFoundException("Publicación no encontrada");
        }
    }
}
