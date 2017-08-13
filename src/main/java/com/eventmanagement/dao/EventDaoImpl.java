package com.eventmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.eventmanagement.dto.EventDTO;

@Repository
public class EventDaoImpl implements EventDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Override
	public int saveEvent(EventDTO eventDTO) {
		Integer result = (Integer) hibernateTemplate.save(eventDTO);
		return result;
	}
	
	@Override
	public List<EventDTO> retrieveAllEvent() {
		List<EventDTO>  eventDTOLst = hibernateTemplate.loadAll(EventDTO.class);
		return eventDTOLst;
	}


	@Override
	public void updateEvent(EventDTO eventDTO) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(eventDTO);
	}

	@Override
	public void deleteEvent(EventDTO eventDTO) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(eventDTO);
	}

	@Override
	public EventDTO retrieveEvent(int id) {
		EventDTO eventDTO = hibernateTemplate.get(EventDTO.class, id);
		return eventDTO;
	}

}
