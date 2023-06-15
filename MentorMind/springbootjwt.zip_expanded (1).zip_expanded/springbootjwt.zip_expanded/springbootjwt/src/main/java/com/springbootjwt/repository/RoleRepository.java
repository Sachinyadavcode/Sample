package com.springbootjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootjwt.model.*;

//inherits a set of CRUD (Create, Read, Update, Delete) operations 
@Repository
public interface RoleRepository extends JpaRepository<Role,Long>
	{
		Optional<Role> findByName(String name);
	}
