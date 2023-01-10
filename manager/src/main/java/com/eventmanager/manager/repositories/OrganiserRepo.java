package com.eventmanager.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanager.manager.entities.Organiser;

public interface OrganiserRepo extends JpaRepository<Organiser, Integer> {

}
