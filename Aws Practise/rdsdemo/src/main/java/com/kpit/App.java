package com.kpit;

/**
 * Hello world!
 *
 */
import java.sql.*;
import java.util.Scanner;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        // String url = "jdbc:mysql://nandinidb.cj8000i6gxgi.eu-west-1.rds.amazonaws.com:3306/student";
        // String uname= "admin";
        // String pswd="nandini123";
        // Connection c = null;
        // try{
        //     try {
        //         Class.forName("com.mysql.cj.jdbc.Driver");
        //     } catch (ClassNotFoundException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     }  //loading jdbc driver
        //     c= DriverManager.getConnection(url,uname,pswd);  // connecting to database
        //     System.out.println("connected successfully");
        //    Statement s = c.createStatement();
        //     ResultSet rs = s.executeQuery("select * from demo");
        //     while(rs.next())
        //     {
        //         System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
        //     }


        // }
        // catch(SQLException ex)
        // {
        //     System.out.println(" sql exception arised"+ex);
        // }
        String url ="jdbc:mysql://nandinidb.cj8000i6gxgi.eu-west-1.rds.amazonaws.com:3306/bills";
        String uname="admin";
        String pwd="nandini123";
        AmazonSNS sns= AmazonSNSClient.builder().withRegion("eu-west-1").build();
        try{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("driver loaded sucessfully");
            Connection con = DriverManager.getConnection(url, uname, pwd);
            System.out.println("connection established successfully");
  /* insert operation */
            // PreparedStatement ps = con.prepareStatement("insert into utilityBill values(?,?,?)");

            // Scanner sc = new Scanner(System.in);
            // System.out.println("enter the month");
            // String m = sc.nextLine();

            // Scanner sc1 = new Scanner(System.in);
            // System.out.println("enter the units");
            // int u = sc1.nextInt();

            // Scanner sc2= new Scanner(System.in);
            // System.out.println("enter the amount");
            // int p = sc2.nextInt();

            // ps.setString(1, m);
            // ps.setInt(2,u);
            // ps.setInt(3, p);


            // ps.executeUpdate();
            // System.out.println("you are inserted successfully");

/*insert operation */
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from utilityBill");
    
            while(rs.next())
            {   String t="arn:aws:sns:eu-west-1:106129732153:bill-alerts";
                String month= rs.getString(1);
                String amount= rs.getString(3);
                sns.publish(t,"your bill for the "+month+"  is "+amount,"monthly bills");
                // System.out.println("details are :");
                // System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getInt(3));
            }

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
}
