package com.example.findNearestPlace.services;

import com.example.findNearestPlace.modals.Place;
import com.example.findNearestPlace.pojoClass.PlacePojo;
import com.example.findNearestPlace.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class PlaceService {


    private final PlaceRepository placeRepository;
    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }


    public List<Place> getAllPlaces() {
       return placeRepository.findAll();
    }

    public void addPlace(Place place) {
        placeRepository.save(place);
    }

    public Place nearestPlaceByCategory(PlacePojo placePojo) {
       List<Place> place = placeRepository.findPlaceByCategory(placePojo.getCategory());
        System.out.println("--------------------------" + place);
        Double minDistance = Double.POSITIVE_INFINITY;
        Place nearestPlace = null;

        for (int i = 0; i < place.size(); i++) {
            double a = Math.abs(placePojo.getLongitude() - place.get(i).getLongitude());
            double b = Math.abs(placePojo.getLatitude() - place.get(i).getLatitude());
            double distance = Math.sqrt(a * a + b * b);

            if (distance < minDistance) {
                minDistance = distance;
                nearestPlace = place.get(i);
            }
        }
        return nearestPlace;


    }
}
