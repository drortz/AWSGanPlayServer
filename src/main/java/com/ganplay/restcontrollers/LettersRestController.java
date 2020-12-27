package com.ganplay.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganplay.controllers.LettersDataController;
import com.ganplay.view.LettersData;

@RestController
public class LettersRestController 
{
	@Autowired
	LettersDataController lettersController;
	
	@CrossOrigin
	@GetMapping("/Letters")
	public List<LettersData> getLettersData()
	{
		return lettersController.getLettersData();
	}
	
	@CrossOrigin
	@PostMapping("/Letters")
	public LettersData addLettersData(@RequestBody LettersData lettersData)
	{
		return lettersController.addLettersData(lettersData);
	}
}
