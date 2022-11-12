package com.neirba.neirba.dto;

import lombok.*;

import java.io.Serializable;

@Getter @Setter
public class CountryDTO implements Serializable {
    Long id;
    String name;
}
