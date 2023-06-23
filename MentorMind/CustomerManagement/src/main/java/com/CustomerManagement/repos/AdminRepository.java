package com.CustomerManagement.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CustomerManagement.entity.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin findByUserNameAndPassword(String userName, String password);
}
