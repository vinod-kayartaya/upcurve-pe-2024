package com.targetindia;

import com.targetindia.model.PersonList;
import org.springframework.web.client.RestTemplate;

public class GetPersonList {
    public static void main(String[] args) {
        String url = "http://localhost:6789/api/customers";
        RestTemplate template = new RestTemplate();

        var resp = template.getForObject(url, PersonList.class);
        System.out.println(resp);

        resp.getPersons().forEach(System.out::println);
    }
}
