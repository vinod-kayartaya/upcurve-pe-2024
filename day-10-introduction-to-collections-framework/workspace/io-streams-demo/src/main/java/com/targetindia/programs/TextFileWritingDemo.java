package com.targetindia.programs;

import java.io.FileOutputStream;
import java.io.PrintStream;

import static com.targetindia.utils.KeyboardUtil.*;

public class TextFileWritingDemo {

    public static void main(String[] args) throws Exception {

        try (
                FileOutputStream file = new FileOutputStream("customers.csv", true);
                PrintStream out = new PrintStream(file);
        ) {
            while (true) {
                System.out.println("enter customer data: ");
                var id = getInt("id: ");
                var name = getString("name: ");
                var city = getString("city: ");
                var email = getString("email: ");
                var phone = getString("phone: ");

                out.printf("%s,%s,%s,%s,%s\n", id, name, city, email, phone);

                var choice = getString("wish to add another? (yes/no) [yes] ");
                if (choice.equalsIgnoreCase("no")) {
                    break;
                }
            }
        } // file.close() called here
    }
}
