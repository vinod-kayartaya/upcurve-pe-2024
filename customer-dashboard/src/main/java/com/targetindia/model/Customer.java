package com.targetindia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id; // GUID (UUID) // java.util.UUID.randomUUID().toString();
    private String name;
    @Column(name = "birth_date")
    private Date birthDate;
    private String email;
    private String phone;
    private String city;
}
