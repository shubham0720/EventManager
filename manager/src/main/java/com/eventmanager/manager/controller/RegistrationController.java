package com.eventmanager.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanager.manager.payloads.ApiResponse;
import com.eventmanager.manager.payloads.RegistrationDto;
import com.eventmanager.manager.services.RegistrationService;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

	@Autowired
	private RegistrationService regService;
	
	@GetMapping("/event/{eventId}/student/{stdId}")
	public ResponseEntity<RegistrationDto> getRegistrationByEventAndStudent(@PathVariable Integer eventId, @PathVariable Integer stdId){
		try {
			RegistrationDto getReg = this.regService.getRegistrationByEventAndStudent(eventId, stdId);
			System.out.println(getReg);
			return new ResponseEntity<RegistrationDto>(getReg, HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity<RegistrationDto>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PostMapping("/event/{eventId}/student/{stdId}")
	public ResponseEntity<RegistrationDto> createRegistration(@RequestBody RegistrationDto regDto,
			@PathVariable Integer eventId, @PathVariable Integer stdId) {
		RegistrationDto createdReg = this.regService.createRegistration(regDto, eventId, stdId);
		return new ResponseEntity<RegistrationDto>(createdReg, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<RegistrationDto>> getAllRegistrations(){
		List<RegistrationDto> registrations = this.regService.getAllRegistrations();
		return new ResponseEntity<>(registrations, HttpStatus.OK);
		
	}
	
	@GetMapping("/{regId}")
	public ResponseEntity<RegistrationDto> getRegById(@PathVariable Integer regId){
		RegistrationDto regDto = this.regService.getRegById(regId);
		return new ResponseEntity<>(regDto, HttpStatus.OK);
	}
	
	@GetMapping("/event/{eventId}")
	public ResponseEntity<List<RegistrationDto>> getRegByEvent(@PathVariable Integer eventId){
		List<RegistrationDto> regByEvent = this.regService.getRegistrationByEvent(eventId);
		return new ResponseEntity<>(regByEvent, HttpStatus.OK);
	}
	
	@GetMapping("/student/{stdId}")
	public ResponseEntity<List<RegistrationDto>> getRegByStudent(@PathVariable Integer stdId){
		List<RegistrationDto> regByStudent = this.regService.getRegistrationByStudent(stdId);
		return new ResponseEntity<>(regByStudent, HttpStatus.OK);
	}
	
	@DeleteMapping("/{regId}")
	public ResponseEntity<ApiResponse> deleteRegistration(@PathVariable Integer regId) {
		this.regService.deleteRegistration(regId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Registration Deleted Successfully", true), HttpStatus.OK);
	}
	
	@DeleteMapping("/event/{eventId}/student/{stdId}")
	public ResponseEntity<ApiResponse> deleteRegistrationByEventAndStudent(@PathVariable Integer eventId, @PathVariable Integer stdId){
		this.regService.deleteRegistrationByEventAndStudentId(eventId, stdId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Registration Delete Successfully with Event id " + eventId + " and studentId " + stdId + "", true), HttpStatus.OK);
	}
}
