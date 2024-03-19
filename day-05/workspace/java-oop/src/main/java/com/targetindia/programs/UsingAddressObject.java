package com.targetindia.programs;

import com.targetindia.model.Address;

public class UsingAddressObject {
    public static void main(String[] args) {
        Address addr1 = new Address();
        addr1.setHouseNoBuilding("TF-1 Elegant Elite");
        addr1.setStreet("1st cross, 1st main");
        addr1.setArea("ISRO layout");
        addr1.setCity("Bangalore");
        addr1.setState("Karnataka");
        addr1.setPincode("560078");
        addr1.setCountry("India");

        System.out.println("Address: ");
        System.out.println(addr1.getHouseNoBuilding());
        System.out.println(addr1.getStreet());
        System.out.println(addr1.getArea());
        System.out.println(addr1.getCity());
        System.out.println(addr1.getState() + " - " + addr1.getPincode());
        System.out.println(addr1.getCountry());

    }
}
