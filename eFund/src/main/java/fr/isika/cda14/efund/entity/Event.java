package fr.isika.cda14.efund.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Event extends ProjectGeneric{
	
	@Column(name="start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	private Integer duration;
	
	private String location;
	
	@Enumerated(EnumType.STRING)
	private EventStatus status;
	
	@Column(name="volunteer_target")
	private Integer volunteerTarget;
}
