package com;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;

public class demo {
    public static void main(String[] args) {
        AmazonSQS sq= AmazonSQSClient.builder().withRegion("eu-west-1").build();
        AmazonSNS sn = AmazonSNSClient.builder().withRegion("eu-west-1").build();
        CreateTopicResult r = sn.createTopic("Topic56");
        String topic =r.getTopicArn();
        sn.subscribe(topic,"email","bnandu5c7@gmail.com");
        SendMessageRequest sr = new SendMessageRequest(topic," hello aws talents");
        sn.publish(topic,sq.sendMessage(sr),"update");
    }
    
}
