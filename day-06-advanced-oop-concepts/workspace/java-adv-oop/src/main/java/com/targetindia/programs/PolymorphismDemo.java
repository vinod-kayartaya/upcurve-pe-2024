package com.targetindia.programs;

import com.targetindia.model.Circle;
import com.targetindia.model.GeometricShape;
import com.targetindia.model.Rectangle;
import com.targetindia.model.Triangle;

public class PolymorphismDemo {

    static void printShapeDetails(GeometricShape shape){
        System.out.println("Shape name is " + shape.getShapeName());
        System.out.println("Created by " + shape.getAuthorName() + ", " + shape.getAuthorEmail());
        System.out.println("Area of this shape is " + shape.getShapeArea() + " sq units.");
        System.out.println();
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(12.34);
        Triangle t1 = new Triangle(12.34, 56.78);

        printShapeDetails(c1); // Circle IS-A GeometricShape
        printShapeDetails(t1); // Triangle IS-A GeometricShape
        printShapeDetails(new Rectangle(12.34, 56.78)); // Rectangle IS-A GeometricShape

    }
}
