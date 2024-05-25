package com.targetindia.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Person {
    private String id;
    @JsonProperty("name")
    private String fullName;
    @JsonProperty("email")
    private String emailAddress;
    @JsonProperty("phone")
    private String phoneNumber;
    private String city;
}
