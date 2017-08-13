package com.eventmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eventmanagement.dao.EventDao;
import com.eventmanagement.dto.EventDTO;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventDao eventDao;
	
	@Override
	@Transactional
	public int saveEvent(EventDTO eventDTO) {
		return eventDao.saveEvent(eventDTO);
	}

	@Override
	@Transactional
	public void updateEvent(EventDTO eventDTO) {
		eventDao.updateEvent(eventDTO);
	}

	@Override
	@Transactional
	public void deleteEvent(EventDTO eventDTO) {
		eventDao.deleteEvent(eventDTO);
	}

	@Override
	@Transactional
	public List<EventDTO> retrieveAllEvent() {
		List<EventDTO> eventDTOLst =  eventDao.retrieveAllEvent();
		return eventDTOLst;
	}

	@Override
	@Transactional
	public EventDTO retrieveEvent(int id) {
		EventDTO eventDTO = eventDao.retrieveEvent(id);
		return eventDTO;
	}

}
