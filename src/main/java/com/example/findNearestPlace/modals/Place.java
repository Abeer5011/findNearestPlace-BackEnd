package com.example.findNearestPlace.modals;
import com.example.findNearestPlace.pojoClass.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name is required")
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String photo;
    private Double longitude;
    private Double latitude;


}
