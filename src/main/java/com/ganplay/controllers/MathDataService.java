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
import java.util.concurrent.ThreadLocalRandom;
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

    private final int NUMBER_OF_MATH_QUESTIONS = 21;

    public MathOutputData receiveMathGame(MathInputData mathInputData)
    {
        List<MathQuestion> mathQuestionList = new ArrayList<>();

        IntStream.range(1, NUMBER_OF_MATH_QUESTIONS).forEach(i -> {
            switch(mathInputData.getGameType())
            {
                case 1:
                    //Addition & Subtraction
                    mathQuestionList.add(createMathQuestionAdditionSubtraction(mathInputData.getLevel(), i));
                    break;
                case 2:
                    //multiplication
                    mathQuestionList.add(createMathQuestionMultiplication(mathInputData.getLevel(), i));
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        });

        MathOutput.setMathQuestions(mathQuestionList);
        return MathOutput;
    }

    private MathQuestion createMathQuestionMultiplication(int level, int id)
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
                high = 99;
                break;
            default:
                low = 1;
                high = 10;
                break;
        }
        int num1 = random.nextInt(high-low) + low;
        int num2 = random.nextInt(high-low) + low;
        String arithmetic = " X ";
        mathQuestion.setMathQuestion(num1 + arithmetic + num2 + " = ");
        int correctAnswer = Math.multiplyExact(num1, num2);
        mathQuestion.setCorrectAnswer(String.valueOf(correctAnswer));

        List<String> multipleChoice = new ArrayList<>();
        multipleChoice.add(mathQuestion.getCorrectAnswer());
        IntStream.range(0, 3).forEach(j-> {
            int choice;
            if(correctAnswer - 15 > 0)
            {
                choice = ThreadLocalRandom.current().nextInt((correctAnswer - 15), (correctAnswer + 15));
                while(multipleChoice.contains(String.valueOf(choice)))
                {
                    choice = ThreadLocalRandom.current().nextInt((correctAnswer - 15), (correctAnswer + 15));
                }
            } else {
                choice = random.nextInt(high - low) + low;
                while (multipleChoice.contains(String.valueOf(choice))) {
                    choice = random.nextInt(high - low) + low;
                }
            }
            multipleChoice.add(String.valueOf(choice));
        });
        Collections.shuffle(multipleChoice);
        mathQuestion.setMultipleChoise(multipleChoice);
        mathQuestion.setId(String.valueOf(id));
        return mathQuestion;
    }

    private MathQuestion createMathQuestionAdditionSubtraction(int level, int id)
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

        mathQuestion.setMathQuestion(num1 + arithmetic + num2 + " = ");
        int correctAnswer;
        if(isAddition) {
            correctAnswer = num1 + num2;
            mathQuestion.setCorrectAnswer(String.valueOf(correctAnswer));
        } else {
            correctAnswer = num1 - num2;
            mathQuestion.setCorrectAnswer(String.valueOf(correctAnswer));
        }

        List<String> multipleChoice = new ArrayList<>();
        multipleChoice.add(mathQuestion.getCorrectAnswer());
        IntStream.range(0, 3).forEach(j-> {
            int choice;

            if(correctAnswer - 10 > 0)
            {
                choice = ThreadLocalRandom.current().nextInt((correctAnswer - 10), (correctAnswer + 10));
                while(multipleChoice.contains(String.valueOf(choice)))
                {
                    choice = ThreadLocalRandom.current().nextInt((correctAnswer - 10), (correctAnswer + 10));
                }
            } else {
                choice = random.nextInt(10-1) + 1;
                while(multipleChoice.contains(String.valueOf(choice)))
                {
                    choice = random.nextInt(10-1) + 1;
                }
            }

            multipleChoice.add(String.valueOf(choice));
        });
        Collections.shuffle(multipleChoice);
        mathQuestion.setMultipleChoise(multipleChoice);
        mathQuestion.setId(String.valueOf(id));
        return mathQuestion;
    }
}
