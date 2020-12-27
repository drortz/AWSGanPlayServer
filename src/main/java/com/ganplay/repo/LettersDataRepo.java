package com.ganplay.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LettersDataRepo extends MongoRepository<com.ganplay.models.LetterData, String> 
{
	
}
