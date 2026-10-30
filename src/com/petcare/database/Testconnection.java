/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.database;

import java.sql.Connection;
import java.sql.SQLException;

public class Testconnection {
    
    public static void main(String[] args){
        
        try{
            Connection con = DaBConnection.getConnection();
            
            System.out.println("Database connected successfully");
            
            con.close();
            
        } catch(SQLException e){
            System.out.println("Database connection failed!");
            System.out.println(e.getMessage());
        }
    }
    
}
