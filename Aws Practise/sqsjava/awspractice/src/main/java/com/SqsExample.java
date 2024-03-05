package com;

import java.util.List;
import java.util.Queue;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class SqsExample {
    public static void main(String[] args) {
        AmazonSQS sq = AmazonSQSClient.builder().withRegion("eu-west-1").build();
        sq.createQueue("que7");
        SendMessageRequest smr = new SendMessageRequest("que7","hello this is sqs example in aws course");
        sq.sendMessage(smr);
         SendMessageRequest smr1 = new SendMessageRequest("que7","this is the code marathon practise");
        sq.sendMessage(smr1);
         SendMessageRequest smr2 = new SendMessageRequest("que7","today is thursday and pray for saibaba");
        sq.sendMessage(smr2);
        System.out.println("message sent successfully");


        List<Message> msg = sq.receiveMessage("que7").getMessages();
        for (Message m : msg) {
            System.out.println("the message is "+m.getBody());
            String s = m.getReceiptHandle();
            sq.deleteMessage("que7",s);
        }
        sq.deleteQueue("que7");
            
        }



        
    }
