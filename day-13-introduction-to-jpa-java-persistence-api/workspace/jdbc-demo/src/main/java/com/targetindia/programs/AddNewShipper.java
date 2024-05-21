package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddNewShipper {
    public static void main(String[] args) {
        // String url = "jdbc:h2:tcp://localhost/~/northwind";
        String url = "jdbc:mysql://localhost/northwind";
        String user = "root";
        String password = "Welcome#123";
        String sql = "insert into SHIPPERS values(?, ?, ?)";
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {

            System.out.println("enter new shipper data: ");
            var id = KeyboardUtil.getInt("id: ");
            var name = KeyboardUtil.getString("name: ");
            var phone = KeyboardUtil.getString("phone: ");

            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, phone);

            stmt.executeUpdate();
            System.out.println("new shipper data added successfully");
        } // all the resource opened at `try()` will be closed
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
