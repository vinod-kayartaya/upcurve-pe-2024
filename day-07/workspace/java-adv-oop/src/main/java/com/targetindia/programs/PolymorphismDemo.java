package com.targetindia.programs;

import com.targetindia.model.Camera;
import com.targetindia.model.MusicPlayer;
import com.targetindia.model.SmartPhone;
import com.targetindia.model.WebCam;

public class PolymorphismDemo {

    static void takeAndPrintPhoto(Camera camera){
        camera.takePicture();
        try {
            camera.deletePicture();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        //...
        //...
    }



    public static void main(String[] args) {

        SmartPhone sp = new SmartPhone();
        MusicPlayer mp = new MusicPlayer();
        WebCam wc = new WebCam();

        takeAndPrintPhoto(sp);
        takeAndPrintPhoto(wc);

        takeAndPrintPhoto(new Camera(){
            @Override
            public void takePicture() {
                System.out.println("taking picture using a handmade camera...");
            }
        });
    }
}
