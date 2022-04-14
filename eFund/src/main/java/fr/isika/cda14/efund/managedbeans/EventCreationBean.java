package fr.isika.cda14.efund.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda14.efund.services.EventCreationService;
import fr.isika.cda14.efund.viewmodel.EventCreationFormVM;

@ManagedBean
public class EventCreationBean {

	@Inject
	private EventCreationService eventCreationService;

	private EventCreationFormVM eventCreationFormVM = new EventCreationFormVM();

	public String createEvent() {
		eventCreationService.create(eventCreationFormVM);
		return "eventCreationForm.xhtml";
	}

	public EventCreationFormVM getEventCreationFormVM() {
		return eventCreationFormVM;
	}

	public void setEventCreationFormVM(EventCreationFormVM eventCreationFormVM) {
		this.eventCreationFormVM = eventCreationFormVM;
	}

}
