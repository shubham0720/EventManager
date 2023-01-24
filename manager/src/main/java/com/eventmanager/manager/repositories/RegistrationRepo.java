package com.eventmanager.manager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanager.manager.entities.Event;
import com.eventmanager.manager.entities.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, Integer> {
	List<Registration> findByEvent(Event event);
}
