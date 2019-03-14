package com.stackroute.recommendation.model;

public class SubmissionDetails {
    String questionId;
    Double score;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        questionId = this.questionId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    String username;
}
