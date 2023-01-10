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
import com.eventmanager.manager.payloads.StudentDto;
import com.eventmanager.manager.services.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	public StudentService stdService;
	
	@PostMapping("/")
	public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto studentDto){
		StudentDto createStudent = this.stdService.createStudent(studentDto);
		return new ResponseEntity<>(createStudent, HttpStatus.CREATED);
	}
	
	@PutMapping("/{stdId}")
	public ResponseEntity<StudentDto> updateStudent(@Valid @RequestBody StudentDto studentDto, @PathVariable Integer stdId){
		StudentDto updateStudent = this.stdService.updateStudent(studentDto, stdId);
		return new ResponseEntity<>(updateStudent, HttpStatus.OK);
	}
	
	@GetMapping("/{stdId}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable Integer stdId){
		return ResponseEntity.ok(this.stdService.getStudentById(stdId));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<StudentDto>> getAllStudents(){
		return ResponseEntity.ok(this.stdService.getAllStudents());
	}
	
	@DeleteMapping("/{stdId}")
	public ResponseEntity<ApiResponse> deleteStudent(@PathVariable Integer stdId){
		this.stdService.deleteStudent(stdId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Student Deleted Successfully", true), HttpStatus.OK);
	}
}
