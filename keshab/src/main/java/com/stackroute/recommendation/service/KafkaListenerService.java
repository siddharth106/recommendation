//package com.stackroute.recommendation.service;
//
//import com.stackroute.recommendation.model.User;
//import com.stackroute.recommendation.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Service
//public class KafkaListenerService {
//
//    @Autowired
//    UserRepository userRepository;
//
//
//    @KafkaListener(topics = "AuthMessage", groupId = "group_id")
//    public void consume(String message){
//        System.out.println("Consumed msg : " + message);
//
//        String [] strMessage = message.split(",");
//        User  user = new User();
//        user.setUsername(strMessage[0].split(":")[1].replace("\"",""));
//        List<String> interest = new ArrayList<>();
//        interest.add(strMessage[8].split(":")[1].replace("\"",""));
//        user.setInterests(interest);
//    }
//}