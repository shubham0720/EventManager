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
import com.eventmanager.manager.payloads.OrganiserDto;
import com.eventmanager.manager.services.OrganiserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/organisers")
public class OrganiserController {
	
	@Autowired
	public OrganiserService orgService;
	
	@PostMapping("/")
	public ResponseEntity<OrganiserDto> createOrganiser(@Valid @RequestBody OrganiserDto organiserDto){
		OrganiserDto createOrganiser = this.orgService.createOrganiser(organiserDto);
		return new ResponseEntity<>(createOrganiser, HttpStatus.CREATED);
	}
	
	@PutMapping("/{orgId}")
	public ResponseEntity<OrganiserDto> updateOrganiser(@Valid @RequestBody OrganiserDto organiserDto, @PathVariable Integer orgId){
		OrganiserDto updateOrganiser = this.orgService.updateOrganiser(organiserDto, orgId);
		return new ResponseEntity<>(updateOrganiser, HttpStatus.OK);
	}
	
	@GetMapping("/{orgId}")
	public ResponseEntity<OrganiserDto> getOrganiser(@PathVariable Integer orgId){
		return ResponseEntity.ok(this.orgService.getOrganiserById(orgId));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<OrganiserDto>> getAllOrganisers(){
		return ResponseEntity.ok(this.orgService.getAllOrganisers());
	}
	
	@DeleteMapping("/{orgId}")
	public ResponseEntity<ApiResponse> deleteOrganiser(@PathVariable Integer orgId){
		this.orgService.deleteOrganiser(orgId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Organiser Deleted Successfully", true), HttpStatus.OK);
	}
}
