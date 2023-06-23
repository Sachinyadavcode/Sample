package com.CustomerManagement.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CustomerManagement.entity.Feedback;

//indicates that the interface is a repository component in the spring framework
@Repository

//inherits a set of CRUD (Create, Read, Update, Delete) operations 
public interface FeedbackRepos extends JpaRepository<Feedback, Integer>
{
	
	//method to get customer by their email and name 
	public Feedback getCustomerByNameAndFeedback(String name,String feedback);

}