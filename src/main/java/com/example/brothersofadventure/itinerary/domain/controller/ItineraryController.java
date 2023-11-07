package com.example.brothersofadventure.itinerary.domain.controller;
import com.example.model.Activity;
import com.example.model.Itinerary;
import com.example.model.User;
import com.example.service.ItineraryService;
import com.example.dto.ActivityDto;
import com.example.dto.ItineraryDto;
import com.example.dto.UserDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/itineraries")
@RequiredArgsConstructor
public class ItineraryController {

    private final ItineraryService itineraryService;

    @PostMapping
    public ResponseEntity<ItineraryDto> createItinerary(@Valid @RequestBody ItineraryDto itineraryDto) {
        ItineraryDto createdItinerary = itineraryService.createItinerary(itineraryDto);
        return new ResponseEntity<>(createdItinerary, HttpStatus.CREATED);
    }

    @GetMapping("/{itineraryId}")
    public ResponseEntity<ItineraryDto> getItineraryById(@PathVariable Long itineraryId) {
        ItineraryDto itineraryDto = itineraryService.getItineraryById(itineraryId);
        return new ResponseEntity<>(itineraryDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ItineraryDto>> getAllItineraries() {
        List<ItineraryDto> itineraries = itineraryService.getAllItineraries();
        return new ResponseEntity<>(itineraries, HttpStatus.OK);
    }

    @PutMapping("/{itineraryId}")
    public ResponseEntity<ItineraryDto> updateItinerary(
            @PathVariable Long itineraryId,
            @Valid @RequestBody ItineraryDto itineraryDto) {
        ItineraryDto updatedItinerary = itineraryService.updateItinerary(itineraryId, itineraryDto);
        return new ResponseEntity<>(updatedItinerary, HttpStatus.OK);
    }

    @DeleteMapping("/{itineraryId}")
    public ResponseEntity<Void> deleteItinerary(@PathVariable Long itineraryId) {
        itineraryService.deleteItinerary(itineraryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{itineraryId}/activities")
    public ResponseEntity<List<ActivityDto>> getActivitiesByItinerary(@PathVariable Long itineraryId) {
        List<ActivityDto> activities = itineraryService.getActivitiesByItinerary(itineraryId);
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @PostMapping("/{itineraryId}/activities")
    public ResponseEntity<ActivityDto> createActivityForItinerary(
            @PathVariable Long itineraryId,
            @Valid @RequestBody ActivityDto activityDto) {
        ActivityDto createdActivity = itineraryService.createActivityForItinerary(itineraryId, activityDto);
        return new ResponseEntity<>(createdActivity, HttpStatus.CREATED);
    }

    @GetMapping("/{itineraryId}/users")
    public ResponseEntity<List<UserDto>> getUsersByItinerary(@PathVariable Long itineraryId) {
        List<UserDto> users = itineraryService.getUsersByItinerary(itineraryId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}