package com.eventmanager.manager.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanager.manager.entities.Event;
import com.eventmanager.manager.entities.Organiser;
import com.eventmanager.manager.exceptions.ResourceNotFoundException;
import com.eventmanager.manager.payloads.EventDto;
import com.eventmanager.manager.repositories.EventRepo;
import com.eventmanager.manager.repositories.OrganiserRepo;
import com.eventmanager.manager.services.EventService;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepo eventRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private OrganiserRepo orgRepo;
	
	@Override
	public EventDto createEvent(EventDto eventDto, Integer orgId) {
		Organiser org = this.orgRepo.findById(orgId).orElseThrow(() -> new ResourceNotFoundException("Organiser", "orgId", orgId));
		Event event = this.modelMapper.map(eventDto, Event.class);
		event.setAddedDate(new Date());
		event.setOrganiser(org);
		Event newEvent = this.eventRepo.save(event);
		return this.modelMapper.map(newEvent, EventDto.class);
	}

	@Override
	public EventDto updateEvent(EventDto eventDto, Integer eventId) {
		Event event = this.eventRepo.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event", "eventId", eventId));
		event.setTitle(eventDto.getTitle());
		event.setContent(eventDto.getContent());
		event.setDateOfEvent(eventDto.getDateOfEvent());
		Event updatedEvent = this.eventRepo.save(event);
		return this.modelMapper.map(updatedEvent, EventDto.class);
	}

	@Override
	public List<EventDto> getAllEvents() {
		List<Event> events = this.eventRepo.findAll();
		List<EventDto> eventDtos = events.stream().map((event) -> this.modelMapper.map(event, EventDto.class)).collect(Collectors.toList());
		return eventDtos;
	}

	@Override
	public EventDto getEventById(Integer eventId) {
		Event event = this.eventRepo.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event", "eventId", eventId));
		return this.modelMapper.map(event, EventDto.class);
	}

	@Override
	public void deleteEvent(Integer eventId) {
		this.eventRepo.delete(this.eventRepo.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event", "eventId", eventId)));
	}

}
