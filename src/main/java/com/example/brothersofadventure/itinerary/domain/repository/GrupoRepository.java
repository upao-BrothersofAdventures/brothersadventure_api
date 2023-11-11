package com.example.brothersofadventure.itinerary.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.brothersofadventure.itinerary.domain.entity.Grupo;

import java.util.List;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

    // Ejemplo: Buscar grupos por nombre
    List<Grupo> findByNombre(String nombre);

    // Ejemplo: Buscar grupos por usuario
    List<Grupo> findByUsuariosId(Long usuarioId);

}
