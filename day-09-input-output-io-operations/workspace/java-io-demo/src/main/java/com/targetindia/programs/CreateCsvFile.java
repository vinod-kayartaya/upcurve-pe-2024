package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

import java.io.*;

public class CreateCsvFile {


    public static void main(String[] args) throws Exception {
        String filename = KeyboardUtil.getString("enter csv file to write to: ");

        File file = new File(filename);
        FileWriter writer;
        PrintWriter out;
        if(file.exists()){
            writer = new FileWriter(file, true);
            out = new PrintWriter(writer);
        }
        else {
            writer = new FileWriter(file, false);
            out = new PrintWriter(writer);
            out.println("firstname,lastname,age,city");
        }

        while(true){
            System.out.println("enter details: ");
            String firstname = KeyboardUtil.getString("firstname: ");
            String lastname = KeyboardUtil.getString("lastname: ");
            int age = KeyboardUtil.getInt("age: ");
            String city = KeyboardUtil.getString("city: ");
            out.printf("%s,%s,%d,%s\n", firstname, lastname, age, city);

            String choice = KeyboardUtil.getString("do you want to add another? (yes/no) [yes]");
            if(choice.trim().equalsIgnoreCase("no")){
                break;
            }
        }

        out.close();
        writer.close();
    }

}
