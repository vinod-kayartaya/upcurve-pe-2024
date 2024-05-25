package com.targetindia;

import com.targetindia.model.Person;
import org.springframework.web.client.RestTemplate;

public class GetCustomerData {

    public static void main(String[] args) {

        RestTemplate template = new RestTemplate();
        String url = "http://localhost:6789/api/customers/0eb31b3d-dde3-4138-9c6e-124fe7264278";
//         String resp = template.getForObject(url, String.class);
//         System.out.println(resp);

        Person p1 = template.getForObject(url, Person.class);
        System.out.println(p1);
        System.out.println("ID   : " + p1.getId());
        System.out.println("Name : " + p1.getFullName());
        System.out.println("Email: " + p1.getEmailAddress());
        System.out.println("City : " + p1.getCity());
        System.out.println("Phone: " + p1.getPhoneNumber());
    }
}
