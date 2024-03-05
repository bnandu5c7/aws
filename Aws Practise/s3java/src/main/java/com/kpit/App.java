package com.kpit;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import java.util.Scanner;


import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class App 
{
    public static void main( String[] args )
    {
    //    AmazonS3 s3= AmazonS3Client.builder().withCredentials( new ProfileCredentialsProvider()).build();
    //     List<Bucket> buckets =s3.listBuckets();
    //     buckets.forEach(bucket -> System.out.println(bucket.getName()));
        // Scanner sc = new Scanner(System.in);
        // s3.createBucket("nandini3"); //to create bucket and upload file as object
        // System.out.println("enter the message");
        // String l=sc.nextLine();                    // this code is about to create bucket and take the message from user and store that in varaible "l" and passing that information to "message.txt"  file under the bucket called "nandini3"
        // s3.putObject("nandini3","message.txt",l);// this line is for object creation 
        // s3.deleteObject("nandini3","message.txt");//to delete object/file from bucket nandini3
        // System.out.println("deleted object successfully");
        // s3.deleteBucket("nandu78"); // to delete bucket 
        // System.out.println("bucket deleted successfully");
        //  s3.deleteBucket("nandini07"); // to delete bucket 
        // System.out.println("bucket deleted successfully");
        // try{
        // s3.createBucket("nandu78"); 
        // System.out.println("generated successfully");  //to create  bucket 
        // }
        // catch(AmazonServiceException e)
        // {
        //     e.printStackTrace();
        // }
        AmazonS3 s = AmazonS3Client.builder().withCredentials(new ProfileCredentialsProvider()).build();
        // List<Bucket> b = s.listBuckets();
        // for(Bucket bs : b)
        // {
        //     System.out.println("bucket is " +bs.getName());
        // }
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the details to jan mnth details");
        String s1 = sc.nextLine();
        s.putObject("nandini-reports","jan.txt",s1);
        System.out.println("enter the details to feb  mnth detils");
        String s2 = sc.nextLine();
        s.putObject("nandini-reports","feb.txt",s2);
        System.out.println("enter the details to march mnth details");
        String s3 = sc.nextLine();
        s.putObject("nandini-reports","march.txt",s3);
        try{
        String c1 = s.getObjectAsString("nandini-reports","jan.txt");
        FileWriter out = new FileWriter(new  File("c:\\files\\jan.txt"));
        out.write(c1);
        out.close();
        }
        catch(Exception e)
        {
            System.out.println("file not found "+e);
        }
    }
}



