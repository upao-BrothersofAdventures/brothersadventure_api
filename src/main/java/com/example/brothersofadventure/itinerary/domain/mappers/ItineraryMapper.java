package com.example.brothersofadventure.itinerary.domain.mappers;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.brothersofadventure.itinerary.domain.dto.ItineraryDto;
import com.example.brothersofadventure.itinerary.domain.dto.ItineraryResponseDto;
import com.example.brothersofadventure.itinerary.domain.entity.Itinerary;

import java.util.List;

@Component
public class ItineraryMapper {
    private final ModelMapper modelMapper;

    public ItineraryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Itinerary resourceToEntity(ItineraryDto itineraryResource) {
        return modelMapper.map(itineraryResource, Itinerary.class);
    }

    public ItineraryDto entityToResource(Itinerary itinerary) {
        return modelMapper.map(itinerary, ItineraryDto.class);
    }

    public ItineraryResponseDto entityToResponseResource(Itinerary itinerary) {
        return modelMapper.map(itinerary, ItineraryResponseDto.class);
    }

    public List<Itinerary> resourceListToEntityList(List<ItineraryDto> itineraryResources) {
        return itineraryResources
                .stream()
                .map(this::resourceToEntity)
                .toList();
    }

    public List<ItineraryDto> entityListToResourceList(List<Itinerary> itineraries) {
        return itineraries
                .stream()
                .map(this::entityToResource)
                .toList();
    }

    public List<ItineraryResponseDto> entityListToResponseResourceList(List<Itinerary> itineraries) {
        return itineraries
                .stream()
                .map(this::entityToResponseResource)
                .toList();
    }
}