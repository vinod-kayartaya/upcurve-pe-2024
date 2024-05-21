package com.targetindia.programs;

import java.sql.DriverManager;

public class GetAvailableDrivers {
    public static void main(String[] args) throws Exception{

        var drivers = DriverManager.getDrivers();
        System.out.println("Here are the available drivers:");
        while(drivers.hasMoreElements()){
            var driver = drivers.nextElement();
            System.out.println(driver.getClass().getName());
        }

        System.out.println("end of main()");
    }
}
