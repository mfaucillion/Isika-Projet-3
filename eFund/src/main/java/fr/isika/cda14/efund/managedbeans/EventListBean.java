package fr.isika.cda14.efund.managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.project.Event;
import fr.isika.cda14.efund.services.EventService;

@ManagedBean
public class EventListBean {

	@Inject
	private EventService eventService;

	private List<Event> eventsList;

	public void onLoad() {
		eventsList = eventService.getAllEvents();
	}

	private List<Event> getAllEvents() {
		return this.eventService.getAllEvents();
	}

	public List<Event> getEvents() {
		return eventsList;
	}

	public void setEvents(List<Event> events) {
		this.eventsList = events;
	}

}
