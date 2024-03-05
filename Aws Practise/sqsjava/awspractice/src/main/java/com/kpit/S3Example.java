package com.kpit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;

public class S3Example {
    public static void main(String[] args) {
        // AmazonS3 s = AmazonS3Client.builder().withCredentials(new ProfileCredentialsProvider()).build();
        AmazonS3 s = AmazonS3Client.builder().withRegion("eu-west-1").build();
        s.createBucket("buc7");
        List<Bucket> b= s.listBuckets();
        for (Bucket bs :b) {
            System.out.println("the bucket names are :"+bs.getName());
        }
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the message ");
        String s1 = sc.nextLine();
        s.putObject("buc7","formal.txt",s1);
        System.out.println("succeffuly object created");
        String content = s.getObjectAsString("buc7","formal.txt");
        try {
             String content = s.getObjectAsString("buc7","formal.txt");
            FileWriter w = new  FileWriter(new File("c:\\files\\formal.txt"));
            w.write(content);
            w.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("successfully downloaded file from bucket");
        s.deleteObject("buc7","formal.txt");
        System.out.println("file is deleted successfully");
        s.deleteBucket("buc7");
    }

    
}
