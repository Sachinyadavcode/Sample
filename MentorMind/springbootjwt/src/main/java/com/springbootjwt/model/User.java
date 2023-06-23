package com.springbootjwt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "auth_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//entity class to register an user into the system 
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="name",length=20)
    private String name;

    @Column(name="email_address",unique=true,length=20)
    private String emailAddress;

    @Column(name="password",length=100)
    private String password;
 
    @NotNull
    @Column(name="city",length=30)
    private String address;
    
    //single role assigned to one user
    @OneToOne(cascade = CascadeType.ALL)
    //used to mark a property or list of properties to be ignored
    @JsonIgnoreProperties
    private Role role;
}