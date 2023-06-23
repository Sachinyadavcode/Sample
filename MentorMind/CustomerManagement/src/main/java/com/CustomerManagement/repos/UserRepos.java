package com.CustomerManagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CustomerManagement.entity.User;


@Repository
public interface UserRepos extends JpaRepository<User, Integer>
{

	User findByUserNameAndPassword(String userName, String password);
}
