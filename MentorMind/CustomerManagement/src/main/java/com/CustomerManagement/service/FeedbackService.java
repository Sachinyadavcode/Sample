package com.CustomerManagement.service;

import com.CustomerManagement.entity.Feedback;

public interface FeedbackService 
{
	//save customer
		Feedback saveFeedback(Feedback feedback);
		
		//check if the customer is present or not
		Integer isFeedbackPresent(Feedback feedback);
}
