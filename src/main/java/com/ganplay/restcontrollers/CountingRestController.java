package com.ganplay.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganplay.controllers.CountingDataController;
import com.ganplay.view.CountingData;

@RestController
public class CountingRestController 
{
	
//	@Autowired
//	private ConfigurableApplicationContext context;
//	
	
	@Autowired
	CountingDataController countingDataController;
	
	@CrossOrigin
	@GetMapping("/CountingData")
	public List<com.ganplay.view.CountingData> getCountingData()
	{
		return countingDataController.getCountingData();
	}
	
	@CrossOrigin
	@PostMapping("/CountingData")
	public CountingData addCountingData(@RequestBody CountingData countingData)
	{
		return countingDataController.addCountingData(countingData);
	}
}
