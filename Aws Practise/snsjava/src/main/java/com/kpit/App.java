package com.kpit;

import java.util.List;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicResult;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.Subscription;
import com.amazonaws.services.sns.model.Topic;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AmazonSNS sn = AmazonSNSClient.builder().withRegion("eu-west-1").build();//getting connected with amazon in specific region
        CreateTopicResult res2 = sn.createTopic("discount_offers27");//create topic
        String topicArn= res2.getTopicArn();//storing that topic name in variable 
        sn.subscribe(topicArn,"email","bnandu5c7@gmail.com");//adding subscribers to that topic
        // ListTopicsResult res = sn.listTopics();
        // List<Topic> t=res.getTopics();
        // for (Topic  t1 : t) {
        //     System.out.println("the topic details are :");
        //     System.out.println("Name :" + t1.getTopicArn().split(":")[5]);
        //     ListSubscriptionsByTopicResult rs = sn.listSubscriptionsByTopic(t1.getTopicArn());//getting all the subscriptions for the specific topic
        //     for(Subscription s:rs.getSubscriptions())
        //     {
        //         System.out.println("\t Subscription:["+s.getProtocol()+"]"+s.getEndpoint());
        //     }
            // sn.publish("arn:aws:sns:eu-west-1:106129732153:nan_topic","hello aws talents","update of aws");//publishing message
            // System.out.println("message sent successfully");
            
        // }
         sn.publish(topicArn,"hello aws talents ...today is the last day for aws and tomorrow we are having code marathon","end of aws");//publishing message
        System.out.println("message sent successfully");
    }
}
