package com.example.brothersofadventure.itinerary.domain.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.brothersofadventure.itinerary.domain.entity.User;
import com.example.brothersofadventure.itinerary.domain.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        userRepository.save(user);
    }

    public boolean isUserAlreadyRegistered(String email) {
        return userRepository.findByCorreoElectronico(email) != null;
    }
}