package com.example.brothersofadventure.itinerary.domain.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registration";  // Página de registro
    }

    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        if (userService.isUserAlreadyRegistered(user.getEmail())) {
            model.addAttribute("error", "El correo electrónico ya está en uso.");
            return "registration"; // Vuelve a la página de registro con un mensaje de error
        }

        userService.registerUser(user);
        return "redirect:/profile";  // Redirige al perfil del usuario después del registro
    }
}
