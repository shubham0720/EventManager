package com.eventmanager.manager.payloads;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RegistrationDto {
	
	private Integer regId;
	
	private Date regDate;
	
	private EventDto event;
	
	private StudentDto student;
}
