package com.stackroute.recommendation.service;

import com.stackroute.recommendation.model.Question;
import com.stackroute.recommendation.model.SubmissionDetails;
import com.stackroute.recommendation.model.User;
import com.stackroute.recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class KafkaListenerService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    public UserService userService;
    @Autowired
    public QuestionTagInfoService tagInfoService;


    @KafkaListener(topics = "AuthMessage", groupId = "group_id_recommend")
    public void consume(String message){
        System.out.println("Consumed msg : " + message);
        String [] strMessage = message.split(",");
        User  user = new User();
        user.setUsername(strMessage[0].split(":")[1].replace("\"",""));
        List<String> interest = new ArrayList<>();
        interest.add(strMessage[8].split(":")[1].replace("\"",""));
        user.setTags((String[]) interest.toArray());
        System.out.println(user.getUsername());
        for(String k:user.getTags()){
            System.out.println(k);
        }

//        if(!(user==null||user.getUsername()==null))
//        {
//
//        User user1 = userService.createUserNode(user);
//        tagInfoService.addTags(user.getTags(),user.getUsername());  }

        }

    @KafkaListener(topics = "SubmissionMessage", groupId = "group_id_recommend")
    public void consumeSubmission(String message){
        System.out.println("Consumed msg : " + message);
        String [] strMessage = message.split(",");
        SubmissionDetails submissionDetails = new SubmissionDetails();
        submissionDetails.setUsername(strMessage[1].split(":")[1].replace("\"",""));
        submissionDetails.setQuestionId(strMessage[2].split(":")[1].replace("\"",""));
        submissionDetails.setScore(Double.parseDouble(strMessage[8].split(":")[1].replace("\"","")));

        System.out.println(submissionDetails.getQuestionId()+submissionDetails.getUsername()+submissionDetails.getScore());
//        if(submissionDetails==null||submissionDetails.getScore()==null||submissionDetails.getUsername()==null)
//            return ;
//        tagInfoService.addOrUpdateTag(submissionDetails.getQuestionId(),submissionDetails.getScore(),submissionDetails.getUsername());

    }

    @KafkaListener(topics = "QuestionMessage", groupId = "group_id_recommend")
    public void consumeQuestion(String message){
        System.out.println("Consumed msg : " + message);
        String [] strMessage = message.split(",");
        Question question = new Question();
        question.setQuestionId(strMessage[0].split(":")[1].replace("\"",""));
        question.setQuestionTitle(strMessage[1].split(":")[1].replace("\"",""));
        question.setDifficulty(strMessage[5].split(":")[1].replace("\"",""));
        question.setTags(strMessage[6].split(":")[1].replace("\"",""));
        System.out.println(question.getQuestionId()+question.getQuestionTitle()+question.getDifficulty()+question.getTags());
       // tagInfoService.saveQuestion(question);
    }
}