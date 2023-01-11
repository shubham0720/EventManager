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
			 
1 Event -> Many student Registrations
			 
Flow of Events
1. Any College admin can register its college
2. There will be one single admin to add all admins
3. Separate domain name for students
4. Any organiser can CRUD any event
5. Students can read event, register in event
6. Separate registrations table