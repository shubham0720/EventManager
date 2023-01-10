Event Manager

Web Application for College Event Management

Features:
	- Available Tables: Organisers, Students, Events, Registrations, Payments
	- Organiser can CRUD Events
	- Users can read/register in event
	- Payments if the event is not free
	

TechStack: 
Backend: Spring Boot
FrontEnd: React
Database: PostgreSQL
Security: JWT

Relations:

1 Organiser -> Event -> One To Many
			   Event
			   Event
			   Event
			   Event
			   
1 Event -> Student -> One To Many
		   Student
		   Student
		   Student
		   Student
		   
1 Student -> Event -> One to Many
			 EVent
			 event
			 event