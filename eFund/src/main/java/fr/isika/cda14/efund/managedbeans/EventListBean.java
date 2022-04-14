package fr.isika.cda14.efund.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.project.Event;
import fr.isika.cda14.efund.services.EventService;

@ManagedBean
public class EventListBean {
	
	@Inject 
	private EventService eventService;
	
	
	private List<Event> events;
	
	@PostConstruct
	private void init() {
		
		events = eventService.getAllEvents();
		
		
	}
	 
	public List<Event> getEvents() {
		return events;
	}
	
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	

}
