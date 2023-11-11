package com.example.brothersofadventure.itinerary.domain.entity;

public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String lugar;
    private String fechaInicio;
    private String fechaFin;
    private String descripcion;


}
