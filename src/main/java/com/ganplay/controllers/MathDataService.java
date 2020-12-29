package com.ganplay.controllers;

import com.ganplay.models.math.MathInputData;
import com.ganplay.models.math.MathOutputData;
import com.ganplay.models.math.MathQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class MathDataService
{
    /*
    Game type (1- addition and subtraction, 2- multiplication, 3- division)
    Level - 1, 2, 3, All (100)
    */

    @Autowired
    private MathOutputData MathOutput;

    private final int NUMBER_OF_MATH_QUESTIONS = 20;

    public MathOutputData receiveMathGame(MathInputData mathInputData)
    {
        switch(mathInputData.getGameType())
        {
            case 1:
                return createAdditionSubtractionGame(mathInputData.getLevel());
            case 2:
                return null;
            case 3:
                return null;
            default:
                return null;
        }
    }

    private MathOutputData createAdditionSubtractionGame(int level)
    {
        List<MathQuestion> mathQuestionList = new ArrayList<>();

        IntStream.range(0, NUMBER_OF_MATH_QUESTIONS).forEach(i -> {
            mathQuestionList.add(createMathQuestionAdditionSubtraction(level));
        });

        MathOutput.setMathQuestions(mathQuestionList);
        return MathOutput;
    }

    private MathQuestion createMathQuestionAdditionSubtraction(int level)
    {
        MathQuestion mathQuestion = new MathQuestion();
        Random random = new Random();
        int low;
        int high;
        switch(level) {
            case 1:
                low = 1;
                high = 10;
                break;
            case 2:
                low = 1;
                high = 100;
                break;
            case 3:
                low = 1;
                high = 1000;
                break;
            default:
                low = 1;
                high = 10;
                break;
        }
        int num1 = random.nextInt(high-low) + low;
        int num2 = random.nextInt(high-low) + low;
        String arithmetic = " + ";
        boolean isAddition = random.nextBoolean();
        if(!isAddition) {
            arithmetic = " - ";
        }
        if(num1 < num2) {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }

        mathQuestion.setMathQuestion(num1 + arithmetic + num2);
        if(isAddition) {
            mathQuestion.setCorrectAnswer(String.valueOf(num1 + num2));
        } else {
            mathQuestion.setCorrectAnswer(String.valueOf(num1 - num2));
        }

        List<String> multipleChoice = new ArrayList<>();
        multipleChoice.add(mathQuestion.getCorrectAnswer());
        IntStream.range(0, 3).forEach(j-> {
            int choice = random.nextInt(high-low) + low;
            while(multipleChoice.contains(String.valueOf(choice)))
            {
                choice = random.nextInt(high-low) + low;
            }
            multipleChoice.add(String.valueOf(choice));
        });
        Collections.shuffle(multipleChoice);
        mathQuestion.setMultipleChoise(multipleChoice);
        return mathQuestion;
    }
}
