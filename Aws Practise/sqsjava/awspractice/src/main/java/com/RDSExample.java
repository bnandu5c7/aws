package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class RDSExample {
    public static void main(String[] args) {
        AmazonSNS sn = AmazonSNSClient.builder().withRegion("eu-west-1").build();
        AmazonSQS sq = AmazonSQSClient.builder().withRegion("eu-west-1").build();
        String url = "jdbc:mysql://nandinidb.cj8000i6gxgi.eu-west-1.rds.amazonaws.com:3306/detail";
        String name="admin";
        String pswd="nandini123";
        String topic="arn:aws:sns:eu-west-1:106129732153:nandinitopic";
        String qurl="https://sqs.eu-west-1.amazonaws.com/106129732153/nanq2";

        try{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("loaded successfully");
            Connection c = DriverManager.getConnection(url, name, pswd);
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("select * from course");
            while(r.next())
            {
                String cname = r.getString(2);
                int cost2=r.getInt(3);
                // sn.publish(topic,"your registered course is "+cname+" and the price you need to pay is "+cost2,"course payment datails");
                // System.out.println("send notification successfully");
                SendMessageRequest req = new SendMessageRequest(qurl,"your registered course is "+cname+" and amount you need to pay is "+cost2);
                sq.sendMessage(req);
            }
            System.out.println("message sent successfully");
            // PreparedStatement p = c.prepareStatement("update course set cprice=? where cid=?");
            // Scanner sc= new Scanner(System.in);
            // System.out.println("enter the cid you want to update");
            // int id = sc.nextInt();
            // p.setInt(2,id);
            // System.out.println("enter the new price of the course");
            // int cost = sc.nextInt();
            // p.setInt(1,cost);
            // p.executeUpdate();
            // System.out.println("updated successfully");
            // PreparedStatement ps = c.prepareStatement("delete from course where cname=?");
            // Scanner s = new Scanner(System.in);
            // String module=s.nextLine();
            // ps.setString(1, module);
            // ps.executeUpdate();
            // System.out.println("deleted successfully");

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
    }
}
