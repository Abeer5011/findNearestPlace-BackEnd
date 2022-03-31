package com.example.findNearestPlace.repository;
import com.example.findNearestPlace.modals.Place;
import com.example.findNearestPlace.pojoClass.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {


    List<Place> findPlaceByCategory(Category category);
}
