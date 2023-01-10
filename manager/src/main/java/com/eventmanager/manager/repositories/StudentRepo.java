package com.eventmanager.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanager.manager.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
