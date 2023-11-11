package com.example.brothersofadventure.itinerary.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String correoElectronico;
    private String password;
    private String Nombres;
    private String Apellidos;
}
