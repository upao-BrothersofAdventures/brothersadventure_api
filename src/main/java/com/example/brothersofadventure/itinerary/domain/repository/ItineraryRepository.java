package com.example.brothersofadventure.itinerary.domain.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.brothersofadventure.itinerary.domain.entity.Itinerary;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {
    //  Buscar itinerarios por nombre
    List<Itinerary> findByNombre(String nombre);

    //  Buscar itinerarios por destino
    List<Itinerary> findByDestino(String destino);

    //  Buscar itinerarios por usuario
    List<Itinerary> findByUsuarioId(Long usuarioId);

    
}
