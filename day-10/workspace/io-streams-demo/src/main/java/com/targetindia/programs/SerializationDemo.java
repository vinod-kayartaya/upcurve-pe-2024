package com.targetindia.programs;

import com.targetindia.model.Customer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static com.targetindia.utils.KeyboardUtil.getInt;
import static com.targetindia.utils.KeyboardUtil.getString;

public class SerializationDemo {

    static void writeToFile(Customer customer, ObjectOutputStream out)  {
        try {
            out.writeObject(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        try (
                FileOutputStream file = new FileOutputStream("customers.data");
                ObjectOutputStream out = new ObjectOutputStream(file);
        ) {
            while (true) {
                System.out.println("enter customer data: ");
                var id = getInt("id: ");
                var name = getString("name: ");
                var city = getString("city: ");
                var email = getString("email: ");
                var phone = getString("phone: ");
                var customer = new Customer(id, name, city, email, phone);

                writeToFile(customer, out);

                var choice = getString("wish to add another? (yes/no) [yes] ");
                if (choice.equalsIgnoreCase("no")) {
                    break;
                }
            }
        } // file.close() called here
    }
}
