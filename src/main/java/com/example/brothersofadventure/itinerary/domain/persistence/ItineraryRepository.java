package com.example.brothersofadventure.itinerary.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {
    // Aquí puedes definir consultas personalizadas si es necesario
}

