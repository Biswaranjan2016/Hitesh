package com.learncodeonline.courses.interviewpreparation.jsonProcessing;

public class TemporaryData {
    private String question;
    private String answer;

    public TemporaryData(){

    }
    public TemporaryData(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public TemporaryData getInstance(){
        return this;
    }
}
