package com.neirba.neirba.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class CityDTO implements Serializable {
    Long id;
    String name;
}
