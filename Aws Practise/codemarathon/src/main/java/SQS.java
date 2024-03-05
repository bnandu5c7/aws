import java.util.Scanner;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class SQS {
    public static void main(String[] args) {
        AmazonSQS sq = AmazonSQSClient.builder().withRegion("eu-west-1").build();
        String qurl="https://sqs.eu-west-1.amazonaws.com/106129732153/ride-requests-nandini";
        System.out.println("connected to aws sqs service successfully");
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the source location :");
        String src= sc.nextLine();
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the destination location :");
        String dest= scan.nextLine();
        SendMessageRequest smr = new SendMessageRequest(qurl,"Book a ride from  "+src+"  and "+dest);
        sq.sendMessage(smr);
        System.out.println("messages sent successfully to queue....");
       

    }
}
