package com.springbootjwt.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "role")
@Data
//This role entity class stores who all can login into the system
public class Role 
{
	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;
 
    //Role of a client
    @NotNull
    @Column(name="user_role")
    @Size(max=25, message = "Role must be at least 25 characters")
    @NotBlank(message = "Must Enter the Role of an User")
    private String name;
    
}
