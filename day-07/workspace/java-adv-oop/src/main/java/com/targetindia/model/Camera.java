package com.targetindia.model;

public interface Camera {
    public void takePicture();

    String authorName = "Vinod";
    public default void deletePicture(){
        throw new RuntimeException("delete not allowed for this device");
    }
}
