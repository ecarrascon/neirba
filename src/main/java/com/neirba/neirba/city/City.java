package com.neirba.neirba.city;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @RequiredArgsConstructor @NoArgsConstructor @ToString
public class City {
    @Id
    @Column(updatable = false, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //NonNull added to everything except "Id" to make a constructor with lombok without ID
    @NonNull
    private String name;




}
