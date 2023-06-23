package com.CustomerManagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerManagement.entity.*;
import com.CustomerManagement.repos.*;
import com.CustomerManagement.service.*;

//indicates that it's a service component and can be automatically detected during component scanning
@Service
public class FeedbackServiceImpl implements FeedbackService
{

	//indicates that it is a dependency that will be automatically injected
	@Autowired
	private FeedbackRepos FeedbackRepository;
	
	// indicates that this method overrides a method from a superclass or interface.
	@Override
	
	//save Feedback
	public Feedback saveFeedback(Feedback feedback)
	{
		return FeedbackRepository.save(feedback);
	}

	@Override
	public Integer isFeedbackPresent(Feedback feedback) 
	{
		 Feedback feedback1 = FeedbackRepository.getCustomerByNameAndFeedback(feedback.getName(),feedback.getFeedback());
	     return feedback1!=null ? feedback1.getId(): null ;
	}
}
