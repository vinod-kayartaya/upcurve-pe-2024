package com.targetindia.programs;

import com.targetindia.model.Customer;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDemo {
    public static void main(String[] args) throws Exception {

        try (
                FileInputStream file = new FileInputStream("customers.data");
                ObjectInputStream in = new ObjectInputStream(file);
        ) {
            while (true) {
                try {
                    Customer c = (Customer) in.readObject();
                    System.out.printf("%s lives in %s\n", c.getName(), c.getCity());
                } catch (EOFException e) {
                    break;
                }
            }
        }

    }
}
