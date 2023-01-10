package com.eventmanager.manager.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanager.manager.entities.Organiser;
import com.eventmanager.manager.exceptions.ResourceNotFoundException;
import com.eventmanager.manager.payloads.OrganiserDto;
import com.eventmanager.manager.repositories.OrganiserRepo;
import com.eventmanager.manager.services.OrganiserService;

@Service
public class OrganiserServiceImpl implements OrganiserService {

	@Autowired
	private OrganiserRepo orgRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public OrganiserDto createOrganiser(OrganiserDto organiserDto) {
		Organiser organiser = this.modelMapper.map(organiserDto, Organiser.class);
		Organiser savedOrganiser = this.orgRepo.save(organiser);
		return this.modelMapper.map(savedOrganiser, OrganiserDto.class);
	}

	@Override
	public OrganiserDto updateOrganiser(OrganiserDto organiserDto, Integer orgId) {
		Organiser organiser = this.orgRepo.findById(orgId).orElseThrow(() -> new ResourceNotFoundException("Organiser", "orgId", orgId));
		organiser.setOrgName(organiserDto.getOrgName());
		organiser.setEmail(organiserDto.getEmail());
		organiser.setDept(organiserDto.getDept());
		Organiser updateOrganiser = this.orgRepo.save(organiser);
		return this.modelMapper.map(updateOrganiser, OrganiserDto.class);
	}

	@Override
	public List<OrganiserDto> getAllOrganisers() {
		List<Organiser> organisers = this.orgRepo.findAll();
		List<OrganiserDto> organiserDtos = organisers.stream().map((org) -> this.modelMapper.map(org, OrganiserDto.class)).collect(Collectors.toList());
		return organiserDtos;
	}

	@Override
	public OrganiserDto getOrganiserById(Integer orgId) {
		Organiser organiser = this.orgRepo.findById(orgId).orElseThrow(() -> new ResourceNotFoundException("Organiser", "orgId", orgId));
		return this.modelMapper.map(organiser, OrganiserDto.class);
	}

	@Override
	public void deleteOrganiser(Integer orgId) {
		this.orgRepo.delete(this.orgRepo.findById(orgId).orElseThrow(() -> new ResourceNotFoundException("Organiser", "orgId", orgId)));
	}

}
