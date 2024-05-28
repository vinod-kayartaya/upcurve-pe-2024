package com.targetindia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name="customers", uniqueConstraints = {
        @UniqueConstraint(name="email_unique_constraint", columnNames = "email"),
        @UniqueConstraint(name="phone_unique_constraint", columnNames = "phone")
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Name is required")
    @Size(min=2, max=50, message = "Name must be between 2 and 50 characters")
    private String name;

    private String city;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email is required")
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    @NotBlank(message = "Phone is required")
    @Column(unique = true)
    private String phone;
}
