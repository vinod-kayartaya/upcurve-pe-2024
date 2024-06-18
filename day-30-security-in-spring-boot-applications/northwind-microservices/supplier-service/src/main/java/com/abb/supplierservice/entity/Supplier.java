package com.abb.supplierservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="suppliers")
public class Supplier {
    @Id
    @Column(name="supplier_id")
    private Integer supplierId;
    @Column(name="company_name")
    private String companyName;
    @Column(name="contact_name")
    private String contactName;
    @Column(name="contact_title")
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    @Column(name="postal_code")
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
    private String homepage;
}
