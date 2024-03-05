import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select {
    public static void main(String[] args) {
        String u="jdbc:mysql://nandinidb.cj8000i6gxgi.eu-west-1.rds.amazonaws.com:3306/bills";
        String uname="admin";
        String pswd="nandini123";
        try{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("successfully driver loaded");
            Connection c= DriverManager.getConnection(u,uname,pswd);
            System.out.println("successfully connected to mysql");
            // Statement s = c.createStatement();
            // String q="select * from utilityBill where month=jan";
            PreparedStatement p = c.prepareStatement("select *from utilityBill where month=?");
            Scanner sc = new Scanner(System.in);
            System.out.println("enter the month in order to retrieve the record :");
            String m = sc.nextLine();
            p.setString(1,m);
            // p.executeUpdate();
            // String mnth="jan";
            ResultSet rs = p.executeQuery();
            while(rs.next())
            {
                System.out.println("the details are :");
                System.out.println("Month :"+rs.getString(1)+ " "+" Units  "+rs.getInt(2)+" "+"amount "+rs.getInt(3));
            }
            

        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
}
