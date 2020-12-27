package com.ganplay.view;

import org.springframework.stereotype.Component;

@Component("CountingDataView")
public class CountingData 
{
	String imageUrl;
	String answer;
	String subject;
	String id;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String sbject) {
		this.subject = sbject;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
