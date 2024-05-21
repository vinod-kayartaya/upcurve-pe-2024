package com.targetindia.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(path = "/", produces = "text/plain")
    public String index(){
        return "This is the home of product-service endpoint accessed via /api/products";
    }
}
