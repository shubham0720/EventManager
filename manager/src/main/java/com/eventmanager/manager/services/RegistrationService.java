package com.eventmanager.manager.services;

import java.util.List;

import com.eventmanager.manager.payloads.RegistrationDto;

public interface RegistrationService {
	RegistrationDto createRegistration(RegistrationDto regDto, Integer eventId, Integer stdId);
	
	List<RegistrationDto> getAllRegistrations();
	
	List<RegistrationDto> getRegistrationByEvent(Integer eventId);
	
	List<RegistrationDto> getRegistrationByStudent(Integer stdId);
	
	RegistrationDto getRegistrationByEventAndStudent(Integer eventId, Integer stdId);
	
	RegistrationDto getRegById(Integer regId);
	
	void deleteRegistration(Integer regId);
}
