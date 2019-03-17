package com.stackroute.recommendation.repository;

import com.stackroute.recommendation.model.QuestionTagInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionTagRepository extends MongoRepository<QuestionTagInfo, String> {


public QuestionTagInfo getByUsernameAndTagName(String username, String tagname);
public List<QuestionTagInfo> getByUsername(String username);
 public Long deleteAllByUsername(String username);


}
