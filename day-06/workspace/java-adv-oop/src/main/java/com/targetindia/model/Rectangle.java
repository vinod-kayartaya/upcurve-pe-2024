package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rectangle extends GeometricShape {

    private double length;
    private double breadth;

    @Override
    public double getShapeArea() {
        return length * breadth;
    }

    @Override
    public String getShapeName() {
        return "Rectangle";
    }
}
