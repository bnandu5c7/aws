package com.kpit;

import java.util.List;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    { 
        AmazonSQS sq=AmazonSQSClient.builder().withCredentials( new ProfileCredentialsProvider()).withRegion("eu-west-1").build();
        String queueUrl ="https://sqs.eu-west-1.amazonaws.com/106129732153/queue7";
        // SendMessageRequest req1 = new SendMessageRequest().withQueueUrl(queueUrl).withMessageBody("hello nandini reddy");
        // sq.sendMessage(req1);  //send msg from user
        List<Message> m =sq.receiveMessage(queueUrl).getMessages();
        //this code is about to retrive message from the provided queue url and display the details in terminal and finally delete that msg 
        for (Message m1 : m) {
            System.out.println("message is :"+m1.getBody()); 
            System.out.println("attributes are "+m1.getAttributes());
            // System.out.println("delete from the queue");
            String  s = m1.getReceiptHandle();//it takes the message and stores in "s"
             sq.deleteMessage(queueUrl,s);
            
        }

    }
}
