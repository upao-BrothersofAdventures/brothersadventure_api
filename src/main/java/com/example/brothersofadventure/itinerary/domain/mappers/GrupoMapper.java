package com.example.brothersofadventure.itinerary.domain.mappers;
import org.modelmapper.ModelMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.brothersofadventure.itinerary.domain.dto.GrupoDto;
import com.example.brothersofadventure.itinerary.domain.dto.GrupoResponseDto;
import com.example.brothersofadventure.itinerary.domain.entity.Grupo;

import java.util.List;

@Mapper
public class GrupoMapper {

    GrupoMapper INSTANCE = Mappers.getMapper(GrupoMapper.class);


    private final ModelMapper modelMapper;

    public GrupoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Grupo resourceToEntity(GrupoDto grupoResource) {
        return modelMapper.map(grupoResource, Grupo.class);
    }

    public GrupoDto entityToResource(Grupo grupo) {
        return modelMapper.map(grupo, GrupoDto.class);
    }

    public GrupoResponseDto entityToResponseResource(Grupo grupo) {
        return modelMapper.map(grupo, GrupoResponseDto.class);
    }

    public List<Grupo> resourceListToEntityList(List<GrupoDto> grupoResources) {
        return grupoResources
                .stream()
                .map(this::resourceToEntity)
                .toList();
    }

    public List<GrupoDto> entityListToResourceList(List<Grupo> grupos) {
        return grupos
                .stream()
                .map(this::entityToResource)
                .toList();
    }

    public List<GrupoResponseDto> entityListToResponseResourceList(List<Grupo> grupos) {
        return grupos
                .stream()
                .map(this::entityToResponseResource)
                .toList();
    }

}
