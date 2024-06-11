package com.targetindia.categoryservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="CATEGORIES")
@Data
public class Category {
    @Id
    @Column(name="category_id")
    private Integer id;
    @Column(name="category_name")
    private String name;
    private String description;
    @JsonIgnore
    private byte[] picture;
}
