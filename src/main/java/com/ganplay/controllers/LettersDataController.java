package com.ganplay.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ganplay.models.LetterData;
import com.ganplay.repo.LettersDataRepo;
import com.ganplay.view.LettersData;

@Controller
public class LettersDataController 
{
	@Autowired
	LettersDataRepo lettersRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	public List<LettersData> getLettersData()
	{
		List<com.ganplay.view.LettersData> returnValue = new ArrayList<>();
		List<LetterData> lettersData = lettersRepo.findAll();
		for (LetterData letterData : lettersData) 
		{
			returnValue.add(modelMapper.map(letterData, com.ganplay.view.LettersData.class));
		}
		
		
		Collections.shuffle(returnValue);
		
		int index = 1;
		for(LettersData letterdata: returnValue)
		{
			String id = String.valueOf(index);
			letterdata.setId(id);
			index++;
		}
		
		return returnValue;
	}
	
	public LettersData addLettersData(LettersData lettersData)
	{
		lettersRepo.save(modelMapper.map(lettersData, com.ganplay.models.LetterData.class));
		return lettersData;
	}
}
