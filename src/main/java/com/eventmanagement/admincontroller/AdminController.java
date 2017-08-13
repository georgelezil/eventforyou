package com.eventmanagement.admincontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagement.dto.EventDTO;
import com.eventmanagement.service.EventService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private EventService eventService;

	@RequestMapping(value = "/inserteventpage")
	public String insertEvent() {
		return "inserteventpage";

	}

	@PostMapping(value = "/insertevent")
	public String insertEvent(@ModelAttribute("event") EventDTO eventDTO, ModelMap theModel) {
		int result = eventService.saveEvent(eventDTO);
		theModel.addAttribute("eventDTOObj", eventDTO);
		return "viewalleventpage";

	}

	@PostMapping(value = "/listallevent")
	public String retrieveAllEvent(ModelMap theModel) {
		List<EventDTO> eventlst = eventService.retrieveAllEvent();
		theModel.addAttribute("eventlist", eventlst);
		return "viewalleventpage";

	}

	@PostMapping(value = "/retrieveevent")
	public String retrieveEvent(@ModelAttribute("id") int eventId, ModelMap theModel) {
		EventDTO eventObj = eventService.retrieveEvent(eventId);
		theModel.addAttribute("eventObj", eventObj);
		return "vieweventpage";

	}

	@PostMapping(value = "/updateevent")
	public String updateEvent(@ModelAttribute("event") EventDTO eventDTO) {
	    eventService.updateEvent(eventDTO);
		return "viewalleventpage";

	}

	@PostMapping(value = "/deleteevent")
	public String deleteEvent(@ModelAttribute("event") EventDTO eventDTO) {
		eventService.deleteEvent(eventDTO);
		return "viewalleventpage";
	}

}
