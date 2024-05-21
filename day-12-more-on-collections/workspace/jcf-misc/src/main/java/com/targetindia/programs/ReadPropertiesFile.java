package com.targetindia.programs;

import java.io.FileReader;
import java.util.Properties;
import java.util.ResourceBundle;

public class ReadPropertiesFile {

    public static void main1(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc-info");
        System.out.println("username is " + rb.getString("username"));
        System.out.println("password is " + rb.getString("password"));
        System.out.println("url is " + rb.getString("url"));

    }
    public static void main(String[] args) {
        Properties props = new Properties();
        System.out.println("no.of entries in props = " + props.size());
        try (
                FileReader reader = new FileReader("src/main/resources/jdbc-info.properties")
        ) {
            props.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("no.of entries in props = " + props.size());
        System.out.println("the keys in props = " + props.keySet());
        System.out.println("the values in props = " + props.values());

        for(var entry: props.entrySet()){
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }

        System.out.println("username is " + props.getProperty("username"));
        System.out.println("password is " + props.getProperty("password"));
        System.out.println("url is " + props.getProperty("url"));
    }
}
