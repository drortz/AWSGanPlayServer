package com.ganplay.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ganplay.models.CountingData;

public interface CountingDataRepo extends MongoRepository<com.ganplay.models.CountingData , String>
{
	
}
