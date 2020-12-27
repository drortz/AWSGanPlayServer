package com.ganplay.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig 
{
	@Bean
	ModelMapper modelMapper()
	{
		ModelMapper modelMapper = new ModelMapper();
		
//		PropertyMap <com.ganplay.view.CountingData, com.ganplay.models.CountingData> propertyMap 
//			= new PropertyMap <com.ganplay.view.CountingData, com.ganplay.models.CountingData>() {
//
//				@Override
//				protected void configure() 
//				{
//					map().setSbject(source.getSbject());
//					
//				}
//			
//		};
//		
//		modelMapper.addMappings(propertyMap);
		
		return modelMapper;
	}
}
