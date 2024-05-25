package com.targetindia.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@JacksonXmlRootElement(localName = "data")
public class CustomerList {
    @JacksonXmlProperty(localName = "customer")
    private List<Customer> customers;
}
