package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadAndPrintFileContent {
    public static void main1(String[] args) {
        var filename = KeyboardUtil.getString("enter filename to read: ");

        FileInputStream file = null;
        try {
            file = new FileInputStream(filename);
            int ch;

            while ((ch = file.read()) != -1) {
                System.out.print((char) ch);
            }

        } catch (FileNotFoundException e) {
            System.out.println("sorry, the given file doesn't exist");
        } catch (IOException e) {
            System.out.println("something went wrong");
            System.out.println(e.getMessage());
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    System.out.println("something wrong while closing the file");
                }
            }
        }
    }

    public static void main(String[] args) {
        var filename = KeyboardUtil.getString("enter filename to read: ");

        try (FileInputStream file = new FileInputStream(filename); ) {
            int ch;

            while ((ch = file.read()) != -1) {
                System.out.print((char) ch);
            }

        } // file.close() is automatically called here
        catch (FileNotFoundException e) {
            System.out.println("sorry, the given file doesn't exist");
        } catch (IOException e) {
            System.out.println("something went wrong");
            System.out.println(e.getMessage());
        }
    }
}
