package com.example.brothersofadventure.itinerary.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrupoDto {
    private Long id;
    private String Contenido;
    private String Remitente;
    private String Fecha_envio;
    private String Destinatario;
    private String Estado;
}
