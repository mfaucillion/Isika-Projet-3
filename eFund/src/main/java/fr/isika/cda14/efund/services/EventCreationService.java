package fr.isika.cda14.efund.services;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.enums.ProjectStatus;
import fr.isika.cda14.efund.entity.project.Event;
import fr.isika.cda14.efund.repositories.EventRepository;
import fr.isika.cda14.efund.viewmodel.EventCreationFormVM;

@Stateless
public class EventCreationService {

	@Inject
	private EventRepository eventRepo;

	public void create(EventCreationFormVM eventCreationFormVM) {
		System.out.println("Service; " + eventCreationFormVM);
		Event newEvent = new Event();
		newEvent.setName(eventCreationFormVM.getName());
		newEvent.setEndDate(eventCreationFormVM.getEndDate());
		newEvent.setSummary(eventCreationFormVM.getSummary());
		newEvent.setImagePath(eventCreationFormVM.getImagePath());
		newEvent.setLocation(eventCreationFormVM.getLocation());
		newEvent.setProjectCategory(eventCreationFormVM.getProjectCategory());
		newEvent.setProjectRange(eventCreationFormVM.getProjectRange());
		newEvent.setVolunteerTarget(eventCreationFormVM.getVolunteerTarget());
		newEvent.setEventStartDate(eventCreationFormVM.getEventStartDate());
		newEvent.setDuration(eventCreationFormVM.getDuration());
		newEvent.setProjectStatus(ProjectStatus.DRAFT);
		newEvent.setCreationDate(new Date());

		eventRepo.create(newEvent);

	}

}