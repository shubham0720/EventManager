package com.eventmanager.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanager.manager.payloads.ApiResponse;
import com.eventmanager.manager.payloads.EventDto;
import com.eventmanager.manager.services.EventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@PostMapping("/organiser/{orgId}/eventadd")
	public ResponseEntity<EventDto> createEvent(@Valid @RequestBody EventDto eventDto, @PathVariable Integer orgId){
		EventDto createdEvent = this.eventService.createEvent(eventDto, orgId);
		return new ResponseEntity<EventDto>(createdEvent, HttpStatus.CREATED);
	}
	
	@PutMapping("/{eventId}")
	public ResponseEntity<EventDto> updateEvent(@Valid @RequestBody EventDto eventDto, @PathVariable Integer eventId){
		EventDto updatedEvent = this.eventService.updateEvent(eventDto, eventId);
		return new ResponseEntity<EventDto>(updatedEvent, HttpStatus.OK);
	}
	
	@GetMapping("/{eventId}")
	public ResponseEntity<EventDto> getEventById(@PathVariable Integer eventId){
		EventDto eventDto = this.eventService.getEventById(eventId);
		return new ResponseEntity<>(eventDto, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<EventDto>> getAllEvents(){
		List<EventDto> events = this.eventService.getAllEvents();
		return new ResponseEntity<>(events, HttpStatus.OK);
	}
	
	@DeleteMapping("/{eventId}")
	public ResponseEntity<ApiResponse> deleteEvent(@PathVariable Integer eventId) {
		this.eventService.deleteEvent(eventId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Event Deleted Successfully", true), HttpStatus.OK);
	}
}
