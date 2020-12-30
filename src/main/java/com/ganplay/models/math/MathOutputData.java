package com.ganplay.models.math;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("MathOutputDataModel")
public class MathOutputData
{
    List<MathQuestion> mathQuestions;

    public List<MathQuestion> getMathQuestions() {
        return mathQuestions;
    }

    public void setMathQuestions(List<MathQuestion> mathQuestions) {
        this.mathQuestions = mathQuestions;
    }

}
