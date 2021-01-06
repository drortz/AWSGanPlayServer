package com.ganplay.models.math;

import org.springframework.stereotype.Component;

@Component("MathInputDataModel")
public class MathInputData
{
    /*
    	Game type (1- addition and subtraction, 2- multiplication, 3- division)
	    Level - 1, 2, 3, All (100)
     */
    private int gameType;
    private int level;
    private int numberOfQuestions;

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }
}
