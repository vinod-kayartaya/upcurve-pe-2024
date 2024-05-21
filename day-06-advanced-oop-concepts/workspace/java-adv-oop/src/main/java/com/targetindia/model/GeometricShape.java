package com.targetindia.model;

public abstract class GeometricShape {

    public static final double PI = 3.141567;

    public abstract double getShapeArea();

    public abstract String getShapeName();

    public String getAuthorName(){
        return "Vinod Kumar Kayartaya";
    }
    public String getAuthorEmail(){
        return "vinod@vinod.co";
    }
}
