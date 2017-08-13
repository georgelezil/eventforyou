package com.eventmanagement.dao;

import java.util.List;

import com.eventmanagement.dto.EventDTO;

public interface EventDao {

	public int saveEvent(EventDTO eventDTO);
	
	public void updateEvent(EventDTO eventDTO);
	
	public void deleteEvent(EventDTO eventDTO);
	
	public List<EventDTO> retrieveAllEvent();
	
	public EventDTO retrieveEvent(int id);
}
