package com.targetindia.programs;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Properties;

public class ReadSystemProps {
    public static void main(String[] args) {
        Properties props = System.getProperties();
        Map<String, String> env = System.getenv();
        Properties envProps = new Properties();
        envProps.putAll(env);
        try (
                PrintWriter out = new PrintWriter("system-properties.txt");
                FileWriter file = new FileWriter("env-variables.txt");
        ) {
            props.store(out, "these are the system properties read from Java");
            envProps.store(file, "environment variables read from Java");
            System.out.println("properties saved to file");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
