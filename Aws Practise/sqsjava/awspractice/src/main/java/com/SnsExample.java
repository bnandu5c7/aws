package com;

import java.util.List;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicResult;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.Subscription;
import com.amazonaws.services.sns.model.Topic;

public class SnsExample {
    public static void main(String[] args) {
        AmazonSNS sn = AmazonSNSClient.builder().withRegion("eu-west-1").build();
         CreateTopicResult tr = sn.createTopic("nandinitopic");
         String topic = tr.getTopicArn();
         sn.subscribe(topic,"email","bnandu5c7@gmail.com");
         sn.publish(topic,"hello tommorow we are having code marathon on aws at 9am to 6pm","Exam Info");
        ListTopicsResult l=sn.listTopics();
        List<Topic> ts = l.getTopics();
        for (Topic t : ts) {
            System.out.println("topic name is "+t.getTopicArn().split(":")[5]);
            ListSubscriptionsByTopicResult sl = sn.listSubscriptionsByTopic(t.getTopicArn());
            List<Subscription> s = sl.getSubscriptions();
            for(Subscription sub :s)
            {
                System.out.println("Subscription"+"["+sub.getProtocol()+"]  "+sub.getEndpoint());
            }
            
        }
        sn.deleteTopic(topic);


    }
}
