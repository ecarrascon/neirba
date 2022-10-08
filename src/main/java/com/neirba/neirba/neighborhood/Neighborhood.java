package com.neirba.neirba.neighborhood;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter @RequiredArgsConstructor @NoArgsConstructor @ToString
public class Neighborhood implements Serializable {

    @Id
    @Column(updatable = false, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //NonNull added to everything except "Id" to make a constructor with lombok without ID
    @NonNull
    private String name;
    @NonNull
    private String neighborhoodType;

}
