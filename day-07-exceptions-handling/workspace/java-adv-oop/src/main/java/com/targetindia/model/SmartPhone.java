package com.targetindia.model;

public class SmartPhone implements Camera{
    public void takePicture(){
        System.out.println("taking a picture using smartphone...");
    }

    public void playMusic(){
        System.out.println("playing music using smartphone...");
    }

    @Override
    public void deletePicture() {
        System.out.println("deleting this picture. are you sure?");
    }
}
