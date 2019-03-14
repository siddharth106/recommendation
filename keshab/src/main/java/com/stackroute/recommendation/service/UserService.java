package com.stackroute.recommendation.service;

import com.stackroute.recommendation.model.Question;
import com.stackroute.recommendation.model.SubmissionScoreDetails;
import com.stackroute.recommendation.model.User;
import com.stackroute.recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


//    public void  Question saveQuestion(Question question){
//           userRepository.saveQuestion(question.getQuestionId(),question.getQuestionTitle(),
//                   question.getQuestionDescription(),question.getDifficulty(),question.getTags());
//    }

    public User createUserNode(User user){
        return userRepository.save(user);
    }
    public User  deleteUser(User user){
          userRepository.delete(user);

        return null;                  }

    public List<Question> getAllQuestions(){

        Random rand = new Random();
        int arr[]=new int [10];

        for(int i=0;i<10;i++)
        {
           int rand_int1 =1+rand.nextInt(45);
           int  j=0;
           while(j<i)
           {
               if(arr[i]==rand_int1)
               {
                   rand_int1=1+rand.nextInt(45);
                   j=0;
               }
               j++;
           }
           arr[i]=rand_int1;
        }
        for(int i=0;i<10;i++)
            System.out.print(arr[i]+" ");

         List<Question> qlist=new ArrayList<Question>();
         for(int i=0;i<10;i++)
         {
             Question q1=userRepository.findquestionbyId(String.valueOf(arr[i]));
             qlist.add(q1);
         }
         return qlist;

    }

}
