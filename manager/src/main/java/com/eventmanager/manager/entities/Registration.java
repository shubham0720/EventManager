package com.eventmanager.manager.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "registrations")
@Getter
@Setter
@NoArgsConstructor
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer regId;
	
	private Date regDate;
	
	@ManyToOne
	private Event event;
	
	@OneToOne
	private Student student;
}
