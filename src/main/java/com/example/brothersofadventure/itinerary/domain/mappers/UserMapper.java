package com.example.brothersofadventure.itinerary.domain.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import com.example.brothersofadventure.itinerary.domain.dto.UserDto;
import com.example.brothersofadventure.itinerary.domain.dto.UserResponseDto;
import com.example.brothersofadventure.itinerary.domain.entity.User;

import java.util.List;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User resourceToEntity(UserDto userResource) {
        return modelMapper.map(userResource, User.class);
    }

    public UserDto entityToResource(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public UserResponseDto entityToResponseResource(User user) {
        return modelMapper.map(user, UserResponseDto.class);
    }

    public List<User> resourceListToEntityList(List<UserDto> userResources) {
        return userResources
                .stream()
                .map(this::resourceToEntity)
                .toList();
    }

    public List<UserDto> entityListToResourceList(List<User> users) {
        return users
                .stream()
                .map(this::entityToResource)
                .toList();
    }

    public List<UserResponseDto> entityListToResponseResourceList(List<User> users) {
        return users
                .stream()
                .map(this::entityToResponseResource)
                .toList();
    }
}