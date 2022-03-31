package com.example.findNearestPlace.pojoClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data @AllArgsConstructor @NoArgsConstructor
public class PlacePojo {

    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String photo;
    private Double longitude;
    private Double latitude;
}
