package com.stackroute.recommendation.repository;
import java.util.List;

import com.stackroute.recommendation.model.Question;
import com.stackroute.recommendation.model.QuestionTagInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionTagRepository extends MongoRepository<QuestionTagInfo, String> {


public  QuestionTagInfo getByUsernameAndTagName(String username,String tagname);
public List<QuestionTagInfo> getByUsername(String username);



}
