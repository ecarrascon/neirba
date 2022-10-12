package com.neirba.neirba.country;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.neirba.neirba.city.City;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "country_name",columnNames = "name")
})
@Getter @Setter @RequiredArgsConstructor @NoArgsConstructor @ToString
public class Country implements Serializable {
    @Id
    @Column(updatable = false, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //NonNull added to everything except "Id" to make a constructor with lombok without ID
    @NonNull
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<City> cities = new HashSet<>();




}