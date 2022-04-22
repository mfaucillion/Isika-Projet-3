package fr.isika.cda14.efund.entity.report;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "event_report")
public class EventReport extends Report {

//	@OneToOne
//	@JoinColumn(name = "event_id")
//	private Event event;

}
