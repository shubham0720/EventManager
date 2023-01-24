package com.eventmanager.manager.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanager.manager.entities.Event;
import com.eventmanager.manager.entities.Registration;
import com.eventmanager.manager.entities.Student;
import com.eventmanager.manager.exceptions.ResourceNotFoundException;
import com.eventmanager.manager.payloads.RegistrationDto;
import com.eventmanager.manager.repositories.EventRepo;
import com.eventmanager.manager.repositories.RegistrationRepo;
import com.eventmanager.manager.repositories.StudentRepo;
import com.eventmanager.manager.services.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepo regRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EventRepo eventRepo;

	@Autowired
	private StudentRepo stdRepo;

	@Override
	public RegistrationDto createRegistration(RegistrationDto regDto, Integer eventId, Integer stdId) {
		Event event = this.eventRepo.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event", "eventId", eventId));
		Student student = this.stdRepo.findById(stdId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "stdId", stdId));
		Registration reg = this.modelMapper.map(regDto, Registration.class);
		reg.setRegDate(new Date());
		reg.setEvent(event);
		reg.setStudent(student);
		Registration newReg = this.regRepo.save(reg);
		return this.modelMapper.map(newReg, RegistrationDto.class);
	}

	@Override
	public List<RegistrationDto> getAllRegistrations() {
		List<Registration> regs = this.regRepo.findAll();
		List<RegistrationDto> regDtos = regs.stream()
				.map((registration) -> this.modelMapper.map(registration, RegistrationDto.class))
				.collect(Collectors.toList());
		return regDtos;
	}

	@Override
	public RegistrationDto getRegById(Integer regId) {
		Registration reg = this.regRepo.findById(regId)
				.orElseThrow(() -> new ResourceNotFoundException("Registration", "regId", regId));
		return this.modelMapper.map(reg, RegistrationDto.class);
	}

	@Override
	public void deleteRegistration(Integer regId) {
		this.regRepo.delete(this.regRepo.findById(regId)
				.orElseThrow(() -> new ResourceNotFoundException("Registration", "regId", regId)));
	}

	@Override
	public List<RegistrationDto> getRegistrationByEvent(Integer eventId) {
		Event event = this.eventRepo.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Event", "eventId", eventId));
		List<Registration> regs = this.regRepo.findByEvent(event);
		List<RegistrationDto> regDtos = regs.stream().map((reg) -> this.modelMapper.map(reg, RegistrationDto.class)).collect(Collectors.toList());
		return regDtos;
	}

}
