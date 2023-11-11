package com.example.brothersofadventure.itinerary.domain.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItineraryDto {
    private Long id;
    private String nombre;
    private String destino;
    private String fecha_inicio;
    private String tag;

    private String fecha_fin;

    private String descripcion;
}
