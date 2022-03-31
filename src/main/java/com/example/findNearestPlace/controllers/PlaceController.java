package com.example.findNearestPlace.controllers;

import com.example.findNearestPlace.modals.ApiResponse;
import com.example.findNearestPlace.modals.Place;
import com.example.findNearestPlace.pojoClass.PlacePojo;
import com.example.findNearestPlace.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class PlaceController {


    private final PlaceService placeService;
    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/places")
    public ResponseEntity<?> getAllPlaces(){
        return ResponseEntity.status(HttpStatus.OK).body(placeService.getAllPlaces());
    }
    @PostMapping("/places")
    public ResponseEntity<?> addPlace(@RequestBody @Valid Place place, Errors errors){
        if(errors.hasErrors()){
          return   ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getFieldError().getDefaultMessage());
        }
        placeService.addPlace(place);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("place is added", 201));
    }

    @PostMapping("/nearestPlaceByCategory")
    public ResponseEntity nearestPlaceByCategory(@RequestBody PlacePojo placePojo){
        return ResponseEntity.status(HttpStatus.OK).body( placeService.nearestPlaceByCategory(placePojo));
    }
}
