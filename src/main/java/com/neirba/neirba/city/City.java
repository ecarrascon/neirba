package com.neirba.neirba.city;

import com.neirba.neirba.country.Country;
import com.neirba.neirba.neighborhood.Neighborhood;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "city_name",columnNames = "name")

})
@Getter @Setter @RequiredArgsConstructor @NoArgsConstructor @ToString
public class City implements Serializable {
    @Id
    @Column(updatable = false, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //NonNull added to everything except "Id" to make a constructor with lombok without ID
    @NonNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_name", referencedColumnName = "name", nullable = false,
            foreignKey=@ForeignKey(name = "FK_country_city"))
    private Country country;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Neighborhood> neighborhoods = new HashSet<>();




}
