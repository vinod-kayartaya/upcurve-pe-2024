package com.targetindia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "CATEGORIES")
public class Category {
    @Id
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "category_name")
    private String categoryName;
    private String description;
    private byte[] picture;

    @OneToMany(mappedBy = "category") // by default fetch type is LAZY for collection types
    // @JoinColumn(name = "category_id")
    private List<Product> products;
}
