package com.neirba.neirba.neighborhood;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.neirba.neirba.city.City;
import com.neirba.neirba.rating.Rating;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "neighborhood_name",columnNames = "name")
})
@Getter @Setter @RequiredArgsConstructor @NoArgsConstructor @ToString
public class Neighborhood implements Serializable {

    @Id
    @Column(updatable = false, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //NonNull added to everything except "Id" to make a constructor with lombok without ID
    @NonNull
    private String name;
    @NonNull
    private String neighborhoodType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_name", referencedColumnName = "name", nullable = false,
            foreignKey=@ForeignKey(name = "FK_city_neighborhood"))
    @JsonBackReference
    private City city;

    @OneToMany(mappedBy = "neighborhood", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Rating> ratings = new HashSet<>();

}
