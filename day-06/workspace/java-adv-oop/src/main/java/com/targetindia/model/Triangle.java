package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Triangle extends GeometricShape{
    private double base;
    private double height;

    @Override
    public double getShapeArea() {
        return base * height / 2;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public String getAuthorName() {
        return "Shyam";
    }

    @Override
    public String getAuthorEmail() {
        return "shyam@xmpl.com";
    }
}
