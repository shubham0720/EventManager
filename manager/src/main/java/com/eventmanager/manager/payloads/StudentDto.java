package com.eventmanager.manager.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
	
	private long stdId;
	
	@NotEmpty
	@Size(min = 3, max = 10, message = "First Name should be min 3 characters and max 10 characters")
	private String firstName;
	
	@Size(min = 3, max = 10, message = "Last Name should be min 3 characters and max 10 characters")
	private String lastName;
	
	@Email
	private String email;
	
	@NotEmpty
	private String dept;
}
