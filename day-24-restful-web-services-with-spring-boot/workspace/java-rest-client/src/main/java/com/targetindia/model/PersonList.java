package com.targetindia.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PersonList {
    @JsonProperty("customers")
    private List<Person> persons;
}
