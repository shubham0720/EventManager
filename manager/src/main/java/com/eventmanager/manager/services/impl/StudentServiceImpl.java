package com.eventmanager.manager.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanager.manager.entities.Student;
import com.eventmanager.manager.exceptions.ResourceNotFoundException;
import com.eventmanager.manager.payloads.StudentDto;
import com.eventmanager.manager.repositories.StudentRepo;
import com.eventmanager.manager.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		Student student = this.modelMapper.map(studentDto, Student.class);
		Student savedStudent = this.studentRepo.save(student);
		return this.modelMapper.map(savedStudent, StudentDto.class);
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto, Integer stdId) {
		Student student = this.studentRepo.findById(stdId).orElseThrow(() -> new ResourceNotFoundException("Student", "stdId", stdId));
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setEmail(studentDto.getEmail());
		student.setDept(studentDto.getDept());
		Student updateStudent = this.studentRepo.save(student);
		return this.modelMapper.map(updateStudent, StudentDto.class);
	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> students = this.studentRepo.findAll();
		List<StudentDto> studentDtos = students.stream().map((std) -> this.modelMapper.map(std, StudentDto.class)).collect(Collectors.toList());
		return studentDtos;
	}

	@Override
	public StudentDto getStudentById(Integer stdId) {
		Student student = this.studentRepo.findById(stdId).orElseThrow(() -> new ResourceNotFoundException("Student", "StdId", stdId));
		return this.modelMapper.map(student, StudentDto.class);
	}

	@Override
	public void deleteStudent(Integer stdId) {
		this.studentRepo.delete(this.studentRepo.findById(stdId).orElseThrow(() -> new ResourceNotFoundException("Student", "stdId", stdId)));
	}
	
}
