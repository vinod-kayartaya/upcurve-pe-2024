package com.targetindia.programs;

import java.sql.DriverManager;

public class ConnectToDatabase {
    public static void main(String[] args) throws Exception {
        System.out.println("trying to connect to a database server...");

        // client-protocol:server-protocol://server-name:port-num/resource
        // https:https://vinod.co:443/tutorials
        // https://vinod.co/tutorials
        // jdbc:mysql://localhost:3306/northwind
        // jdbc:mysql://localhost/northwind
        // jdbc:h2:tcp://localhost/~/northwind

        // String url = "jdbc:mysql://localhost/northwind";
        String url = "jdbc:h2:tcp://localhost/~/northwind";
        String user = "root";
        String password = "Welcome#123";

        var conn = DriverManager.getConnection(url, user, password);
        System.out.println("got a connection of type: " + conn.getClass().getName());
        conn.close();
    }
}
