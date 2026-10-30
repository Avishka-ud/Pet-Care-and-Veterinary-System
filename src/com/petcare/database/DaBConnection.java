/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaBConnection {

public static Connection getConnection() throws SQLException {

    String url = "jdbc:mysql://localhost:3306/petcaredb";
    String username = "root";
    String password = "";

    return DriverManager.getConnection(url, username, password);
}

}



 