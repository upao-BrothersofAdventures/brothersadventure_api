package com.example.brothersofadventure.itinerary.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.brothersofadventure.itinerary.domain.entity.Publicacion;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

    //  Buscar publicaciones por título
    List<Publicacion> findByTitulo(String titulo);

    // Buscar publicaciones por usuario
    List<Publicacion> findByUsuarioId(Long usuarioId);

    //  Buscar publicaciones por itinerario
    List<Publicacion> findByItineraryId(Long itineraryId);

    // Este método ya es proporcionado por JpaRepository, pero puedes definirlo explícitamente si quieres.
    Optional<Publicacion> findById(Long id);

    
}
