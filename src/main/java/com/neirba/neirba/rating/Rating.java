package com.neirba.neirba.rating;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.neirba.neirba.neighborhood.Neighborhood;
import com.neirba.neirba.security.user.UserSecurity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @RequiredArgsConstructor @NoArgsConstructor @ToString
public class Rating implements Serializable {
    @Id
    @Column(updatable = false, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Float score;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "neighborhood_name", referencedColumnName = "name", nullable = false,
            foreignKey=@ForeignKey(name = "FK_neighborhood_rating"))
    @JsonBackReference
    private Neighborhood neighborhood;

    @OneToMany
    @JsonManagedReference
    private Set<UserSecurity> users = new HashSet<>();



}
