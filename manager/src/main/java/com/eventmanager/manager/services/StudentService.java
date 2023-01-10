package com.eventmanager.manager.services;

import java.util.List;

import com.eventmanager.manager.payloads.StudentDto;

public interface StudentService {
	StudentDto createStudent(StudentDto studentDto);
	StudentDto updateStudent(StudentDto studentDto, Integer stdId);
	List<StudentDto> getAllStudents();
	StudentDto getStudentById(Integer stdId);
	void deleteStudent(Integer stdId);
}
