package com;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;

public class SQSSNS {
    public static void main(String[] args) {
AmazonSQS amazonSQS = AmazonSQSClient.builder().withRegion("eu-west-1").build();
String queueUrl = "https://sqs.eu-west-1.amazonaws.com/106129732153/ruchitha";
System.out.println("SQS Loaded");
 
AmazonSNS amazonSNS = AmazonSNSClient.builder().withRegion("eu-west-1").build();
System.out.println("SNS Loaded");
 
String arn = "arn:aws:sns:eu-west-1:106129732153:ruchitha";
 
ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest().withQueueUrl(queueUrl)
.withMaxNumberOfMessages(5);
ReceiveMessageResult receMessageResult = amazonSQS.receiveMessage(receiveMessageRequest);
 
System.out.println("Message received from SQS Queue");
 
for (Message message : receMessageResult.getMessages()) {
System.out.println("Message " + message.getBody());
System.out.println("Attributes " + message.getMessageAttributes());
PublishRequest publishRequest = new PublishRequest().withTopicArn(arn).withMessage(message.getBody());
amazonSNS.publish(publishRequest);
System.out.println("Message Published");
;
 
}
 
}
}
