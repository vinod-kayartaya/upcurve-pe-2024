package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Circle extends GeometricShape{
    private double radius;

    @Override
    public double getShapeArea() {
        return super.PI * this.radius * this.radius;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }
}
