package com.ganplay.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ganplay.repo.CountingDataRepo;
import com.ganplay.view.CountingData;

@Controller
public class CountingDataController 
{
	@Autowired
	CountingDataRepo countingDataRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	public List<CountingData> getCountingData()
	{
		List<com.ganplay.models.CountingData> countingDataViewList = countingDataRepo.findAll();
		List<CountingData> returnValue = new ArrayList<>();
		for (com.ganplay.models.CountingData countingData : countingDataViewList) 
		{
			returnValue.add(modelMapper.map(countingData, com.ganplay.view.CountingData.class));
		}
		
		Collections.shuffle(returnValue);
		
		int index = 1;
		for(CountingData countingData: returnValue)
		{
			String id = String.valueOf(index);
			countingData.setId(id);
			index++;
		}
		
		return returnValue;
	}
	
	public CountingData addCountingData(CountingData countingData)
	{
		countingDataRepo.save(modelMapper.map(countingData, com.ganplay.models.CountingData.class));
		return countingData;
	}
}
