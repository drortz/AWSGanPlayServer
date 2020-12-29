package com.ganplay.models.math;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MathQuestion
{
    private String mathQuestion;
    private List<String> multipleChoise;
    private String correctAnswer;

    public String getMathQuestion() {
        return mathQuestion;
    }

    public void setMathQuestion(String mathQuestion) {
        this.mathQuestion = mathQuestion;
    }

    public List<String> getMultipleChoise() {
        return multipleChoise;
    }

    public void setMultipleChoise(List<String> multipleChoise) {
        this.multipleChoise = multipleChoise;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
