package com.example.brothersofadventure.itinerary.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByCorreoElectronico(String correoElectronico);
}

