package com.eventmanager.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventmanager.manager.entities.Event;

public interface EventRepo extends JpaRepository<Event, Integer> {

}
