package com.CustomerManagement.entity;
import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="customer_feedback")
public class Feedback 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 	
	//indicates that the value cannot be null
	@Column(name="Name", nullable = false, length = 20)
    private String name;
    
	//indicates that the value cannot be null
	@Column(name ="Feedback",nullable = false, length = 20)
    private String feedback;
	
 	
	//Parameterized Constructor
    public Feedback(String name, String feedback)
    {
        this.name = name;
        this.feedback = feedback;
    }
}
