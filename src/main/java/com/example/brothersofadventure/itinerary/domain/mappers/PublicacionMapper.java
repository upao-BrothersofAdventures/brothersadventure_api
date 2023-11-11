package com.example.brothersofadventure.itinerary.domain.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.brothersofadventure.itinerary.domain.dto.PublicacionDto;
import com.example.brothersofadventure.itinerary.domain.dto.PublicacionResponseDto;
import com.example.brothersofadventure.itinerary.domain.entity.Publicacion;

import java.util.List;

@Component
public class PublicacionMapper {
    private final ModelMapper modelMapper;

    public PublicacionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Publicacion resourceToEntity(PublicacionDto publicacionResource) {
        return modelMapper.map(publicacionResource, Publicacion.class);
    }

    public PublicacionDto entityToResource(Publicacion publicacion) {
        return modelMapper.map(publicacion, PublicacionDto.class);
    }

    public PublicacionResponseDto entityToResponseResource(Publicacion publicacion) {
        return modelMapper.map(publicacion, PublicacionResponseDto.class);
    }

    public List<Publicacion> resourceListToEntityList(List<PublicacionDto> publicacionResources) {
        return publicacionResources
                .stream()
                .map(this::resourceToEntity)
                .toList();
    }

    public List<PublicacionDto> entityListToResourceList(List<Publicacion> publicaciones) {
        return publicaciones
                .stream()
                .map(this::entityToResource)
                .toList();
    }

    public List<PublicacionResponseDto> entityListToResponseResourceList(List<Publicacion> publicaciones) {
        return publicaciones
                .stream()
                .map(this::entityToResponseResource)
                .toList();
    }
}
