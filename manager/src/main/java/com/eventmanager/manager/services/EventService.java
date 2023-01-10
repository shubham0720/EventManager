package com.eventmanager.manager.services;

import java.util.List;

import com.eventmanager.manager.payloads.EventDto;

public interface EventService {
	EventDto createEvent(EventDto eventDto, Integer orgId);
	
	EventDto updateEvent(EventDto eventDto, Integer eventId);
	
	List<EventDto> getAllEvents();
	
	EventDto getEventById(Integer eventId);
	
	void deleteEvent(Integer eventId);
}
