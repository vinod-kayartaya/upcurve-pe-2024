package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class ReadTextFileContent {

    public static void main1(String[] args) throws Exception {
        String filename = KeyboardUtil.getString("enter filename: ");
        try (
                FileReader reader = new FileReader(filename);
        ) {
            int ch;
            int loopCount = 0;
            while ((ch = reader.read()) != -1) {
                loopCount++;
                System.out.print((char) ch);
            }
            System.out.println("Total loop count = " + loopCount);
        } // reader.close() is called automatically
    }

    public static void main2(String[] args) throws Exception {
        String filename = KeyboardUtil.getString("enter filename: ");
        try (
                FileReader reader = new FileReader(filename);
                BufferedReader in = new BufferedReader(reader);
        ) {
            int loopCount = 0;
            String line;
            while ((line = in.readLine()) != null) {
                loopCount++;
                System.out.println(line);
            }
            System.out.println("Total loop count = " + loopCount);
        } // in.close(); reader.close(); // called here
    }

    public static void main(String[] args) throws Exception {
        String filename = KeyboardUtil.getString("enter filename: ");

        try (
                FileInputStream in = new FileInputStream(filename);
        ) {
            int loopCount = 0;
            while (true) {
                int size = in.available();

                if (size == 0) {
                    break;
                }
                loopCount++;
                byte[] bytes = new byte[size];
                in.read(bytes);
                System.out.print(new String(bytes));
                System.out.printf("read %d bytes\n", size);
            }
            System.out.println("Total loop count = " + loopCount);
        } // in.close(); called here
    }

}
