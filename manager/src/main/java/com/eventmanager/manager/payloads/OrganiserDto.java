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
public class OrganiserDto {
	
	private long orgId;
	
	@NotEmpty
	@Size(min = 3, max = 20, message = "Name should be min 3 characters and max 20 characters")
	private String orgName;
	
	@Email
	private String email;
	
	@NotEmpty
	private String dept;
}
