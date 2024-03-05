package com.kpit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class rideDetails {
    public static void main(String[] args) {
       String rdsUrl ="jdbc:mysql://kuber-cabs-nandini.cj8000i6gxgi.eu-west-1.rds.amazonaws.com:3306/Ride";
       String uname="admin";
       String pswd ="nandini678";
       try{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("driver loaded successfully.....");
        Connection c = DriverManager.getConnection(rdsUrl, uname, pswd);
        System.out.println("connection established successfully");
        PreparedStatement ps = c.prepareStatement("insert into rideDetails(DriverName,CustomerName,PassengerCount) values(?,?,?)");
        System.out.println("preparing statements");
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the driver name ");
        String dname =sc.nextLine();
        ps.setString(1, dname);
        Scanner sc1= new Scanner(System.in);
        System.out.println("enter the customer name ");
        String cname =sc1.nextLine();
        ps.setString(2, cname);
        Scanner sc3= new Scanner(System.in);
        System.out.println("enter the no of passengers");
        int count =sc3.nextInt();
        ps.setInt(3, count);
        ps.executeUpdate(); 
        System.out.println("statements executed successfully");  
       }
       catch(SQLException e)
       {
        System.out.println(e);
       }

    }
    
}
