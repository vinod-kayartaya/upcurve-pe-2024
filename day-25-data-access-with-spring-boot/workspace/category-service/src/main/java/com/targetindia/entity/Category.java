package com.targetindia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="CATEGORIES")
@JacksonXmlRootElement(localName = "category")
public class Category {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name="category_id")
    private Integer id;
    @Column(name="category_name")
    private String name;
    private String description;
    @JsonIgnore
    private byte[] picture;
}
