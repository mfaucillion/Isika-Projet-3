package fr.isika.cda14.efund.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;

	private String message;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	
	private String parent;
	
	private String child;
	

	
	
}
