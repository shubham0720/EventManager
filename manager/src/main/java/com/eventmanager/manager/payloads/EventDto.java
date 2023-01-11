package com.eventmanager.manager.payloads;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EventDto {
	
	private Integer eventId;
	
	@NotEmpty
	@Size(min = 3, max = 20, message = "Title should be min 3 characters and max 20 characters")
	private String title;
	
	@Size(min = 3, max = 2000, message = "Description should be min 3 characters and max 20 characters")
	private String content;
	
	private Date addedDate;
	
	@NotNull
	private Date dateOfEvent;
	
	private OrganiserDto organiser;
}
