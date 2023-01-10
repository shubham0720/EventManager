package com.eventmanager.manager.services;

import java.util.List;

import com.eventmanager.manager.payloads.OrganiserDto;

public interface OrganiserService {
	OrganiserDto createOrganiser(OrganiserDto organiserDto);
	OrganiserDto updateOrganiser(OrganiserDto organiserDto, Integer orgId);
	List<OrganiserDto> getAllOrganisers();
	OrganiserDto getOrganiserById(Integer orgId);
	void deleteOrganiser(Integer orgId);
}
