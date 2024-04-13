package com.targetindia.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Customer implements Serializable {
    private String id; // GUID (UUID) // java.util.UUID.randomUUID().toString();
    private String name;
    private Date birthDate;
    private String email;
    private String phone;
    private String city;
}
