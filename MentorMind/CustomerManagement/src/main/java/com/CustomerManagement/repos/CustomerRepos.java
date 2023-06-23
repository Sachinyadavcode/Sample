package com.CustomerManagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.CustomerManagement.entity.*;

//indicates that the interface is a repository component in the spring framework
@Repository

////inherits a set of CRUD (Create, Read, Update, Delete) operations 
public interface CustomerRepos extends JpaRepository<Customer, Integer> 
{

}