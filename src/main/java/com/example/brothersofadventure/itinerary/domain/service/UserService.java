package com.example.brothersofadventure.itinerary.domain.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        userRepository.save(user);
    }

    public boolean isUserAlreadyRegistered(String email) {
        return userRepository.findByEmail(email) != null;
    }
}