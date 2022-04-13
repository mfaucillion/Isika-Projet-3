package fr.isika.cda14.efund.entity.report;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String commentReport;

	@Column(name = "report_date")
	@Temporal(TemporalType.DATE)
	protected Date reportDate;

}
