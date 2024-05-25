package com.targetindia.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "customer")
public class Customer {
    private String id; // UUID.randomUUID().toString();
    private String name;
    private String email;
    private String phone;
    private String city;
}
