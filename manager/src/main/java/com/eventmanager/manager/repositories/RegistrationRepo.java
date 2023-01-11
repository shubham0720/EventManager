package com.eventmanager.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanager.manager.entities.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, Integer> {

}
