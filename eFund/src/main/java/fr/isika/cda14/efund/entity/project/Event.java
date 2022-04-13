package fr.isika.cda14.efund.entity.project;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Event extends GenericProject {

	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	private Integer duration;

	private String location;

	@Column(name = "volunteer_target")
	private Integer volunteerTarget;
}
