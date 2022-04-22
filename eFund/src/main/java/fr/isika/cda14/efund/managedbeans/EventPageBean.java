package fr.isika.cda14.efund.managedbeans;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.isika.cda14.efund.entity.account.OrganizationAccount;
import fr.isika.cda14.efund.entity.project.Event;
import fr.isika.cda14.efund.services.EventService;

@ManagedBean
@ViewScoped
public class EventPageBean {
	
	@Inject
	private EventService eventService;
	
	private Event event;
	
	private OrganizationAccount organizationAccount;
	
	private Long remainingDays;
	
	private Long registerDuration;
	
	public void onLoad(String id) {
		this.event = eventService.findEvent(Long.parseLong(id));
		this.organizationAccount=eventService.getOrgFromEvent(Long.parseLong(id));
		this.remainingDays = calculRemainingDays();
		this.registerDuration = calculRegisterDuration();
	}
	
	public int percentage(Integer volunteerCurrent, Integer volunteerTarget) {
		return (volunteerCurrent * 100) / volunteerTarget;
	}
	
	public Long calculRegisterDuration() {
		Date endDate = new Date(this.event.getEndDate().getTime());
		Date startDate = new Date(this.event.getCreationDate().getTime());
		ZonedDateTime endDateTime = ZonedDateTime.ofInstant(endDate.toInstant(), ZoneId.of("UTC"));
		ZonedDateTime startDateTime = ZonedDateTime.ofInstant(startDate.toInstant(), ZoneId.of("UTC"));
		
		return ChronoUnit.DAYS.between(startDateTime, endDateTime);
	}
	
	public int countDown(BigDecimal remaining, BigDecimal duration) {
		
		return ((remaining.intValue() * 100) / duration.intValue());
	}
	
	private Long calculRemainingDays() {
		Date endDate = new Date(this.event.getEndDate().getTime());
		ZonedDateTime endDateTime = ZonedDateTime.ofInstant(endDate.toInstant(), ZoneId.of("UTC"));

		return ChronoUnit.DAYS.between(ZonedDateTime.now(), endDateTime);
	}

	public Event getEvent() {
		return event;
	}

	public OrganizationAccount getOrganizationAccount() {
		return organizationAccount;
	}
	
	public Long getRemainingDays() {
		return remainingDays;
	}

	public EventService getEventService() {
		return eventService;
	}

	public Long getRegisterDuration() {
		return registerDuration;
	}
	


}
