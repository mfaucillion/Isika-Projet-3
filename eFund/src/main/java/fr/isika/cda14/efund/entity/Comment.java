package fr.isika.cda14.efund.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;

	private String message;
	
	@Column(name="creation_date")
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	private String parent;
	
	private String child;
	
	@ManyToOne 
	private GenericProject projectGeneric;

	
}
