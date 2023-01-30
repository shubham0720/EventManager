package com.eventmanager.manager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanager.manager.entities.Event;
import com.eventmanager.manager.entities.Registration;
import com.eventmanager.manager.entities.Student;

public interface RegistrationRepo extends JpaRepository<Registration, Integer> {
	List<Registration> findByEvent(Event event);
	List<Registration> findByStudent(Student student);
	Registration findByEventAndStudent(Event eventId, Student stdId);
}
