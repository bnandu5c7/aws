package com.kpit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

public class S3 {
    public static void main(String[] args) {
        AmazonS3 s = AmazonS3Client.builder().withRegion("eu-west-1").build();
      
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the path you want to download from s3 bucket ");
        String path = sc.nextLine();
        try {
            String content = s.getObjectAsString("bnandinibuck2","driver-id2.jpg");
            FileWriter out = new FileWriter( new File(path));
            out.write(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("file downloaded succsessfully");
    }
    
}
